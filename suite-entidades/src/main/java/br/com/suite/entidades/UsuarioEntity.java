package br.com.suite.entidades;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "tbl_usuario")
@JsonInclude(Include.NON_NULL)
public class UsuarioEntity extends PadraoEntity<String> implements UserDetails {

	private static final long serialVersionUID = 4669588797096293307L;
	
	@NotNull
	private String nome;
	@NotNull		
	private String sobreNome;
	
	
	@Column(unique = true)	
	@NotNull(message="{form.email.notnull}")
	private String email;
	
	@NotNull
	@JsonIgnore
	private String senha;	
	@JsonIgnore
	@Column(length = 128)
	private String restReset;
	@JsonIgnore
	private Date restValidade;
	
	@JoinTable(
			name = "tbl_usuario_role", 
			joinColumns = {	@JoinColumn(name = "usuario_id", referencedColumnName = "id") }, 
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id") }, 
			uniqueConstraints = {@UniqueConstraint(columnNames = { "usuario_id", "role_id" }) })	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<RoleEntity> roles;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName="id", name="theme_id")
	private LayoutEntity layout;

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
	
	public String getRestReset() {
		return restReset;
	}

	public void setRestReset(String restReset) {
		this.restReset = restReset;
	}

	public Date getRestValidade() {
		return restValidade;
	}

	public void setRestValidade(Date restValidade) {
		this.restValidade = restValidade;
	}
	
	public LayoutEntity getLayout() {
		return layout;
	}

	public void setLayout(LayoutEntity layout) {
		this.layout = layout;
	}

	
	// Implementação Spring Security

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return !this.excluido;
	}

}
