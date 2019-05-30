package br.com.suite.entidades;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_empresa")
public class EmpresaEntity extends PadraoEntity<String>{

	private static final long serialVersionUID = 7812354431079225934L;
	
	@NotEmpty(message="{empresa.prop.cnpjcpf.notempty}")
	@Column(length=15)
	private String cnpjCpf;
	
	@Column(length=100)
	@Size(max=100, message="{empresa.prop.razaosocial.size}")
	@NotEmpty(message="{empresa.prop.razaosocial.notempty}")	
	private String razaoSocial;
	
	private boolean sincronizando = false;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	private Set<RegiaoEntity> regioes;
			
	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public boolean isSincronizando() {
		return sincronizando;
	}

	public void setSincronizando(boolean sincronizando) {
		this.sincronizando = sincronizando;
	}

	public Set<RegiaoEntity> getRegioes() {
		return regioes;
	}

	public void setRegioes(Set<RegiaoEntity> regioes) {
		this.regioes = regioes;
	}
		
	@Override
	public String getPrimaryKey() {		
		return this.cnpjCpf.replaceAll(".", "").replaceAll("/", "").replaceAll("-","");
	}	
	
}
