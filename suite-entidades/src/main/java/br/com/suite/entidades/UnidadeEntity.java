package br.com.suite.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_unidade")
public class UnidadeEntity extends PadraoEntity<String> {

	private static final long serialVersionUID = 4842836935583260689L;

	private String descricao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "regiao_fk")
	private RegiaoEntity regiao;

	@JoinTable(name = "tbl_rel_unidade_x_usuario", joinColumns = {
			@JoinColumn(name = "unidade_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "usuario_id", referencedColumnName = "id") }, uniqueConstraints = {
	@UniqueConstraint(columnNames = {"unidade_id", "usuario_id"}) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<UsuarioEntity> usuarios;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public RegiaoEntity getRegiao() {
		return regiao;
	}

	public void setRegiao(RegiaoEntity regiao) {
		this.regiao = regiao;
	}

	public Set<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	
}
