package br.com.suite.entidades;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_regiao")
public class RegiaoEntity extends PadraoEntity<String>{

	private static final long serialVersionUID = 5193205826885672272L;
	
	private String descricao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private EmpresaEntity empresa;
	
	@OneToMany(mappedBy = "regiao", fetch = FetchType.LAZY)
	private Set<UnidadeEntity> unidades;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public Set<UnidadeEntity> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<UnidadeEntity> unidades) {
		this.unidades = unidades;
	}
	
	

}
