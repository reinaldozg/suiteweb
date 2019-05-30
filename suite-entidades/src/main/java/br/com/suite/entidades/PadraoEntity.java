package br.com.suite.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.suite.utils.GeradorPrimaryKeyUtils;


@MappedSuperclass
public class PadraoEntity<E> implements Serializable {

	private static final long serialVersionUID = 8774409275706253303L;

	@Id
	@Column(length = 80)
	protected E id;

	@Column(name = "dt_atualizacao")
	protected Date dtAtualizacao;
	@Column(nullable = false)
	protected Boolean excluido = false;

	public E getId() {
		return id;
	}

	public void setId(E id) {
		this.id = id;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PadraoEntity<?> other = (PadraoEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String getPrimaryKey(){
		return GeradorPrimaryKeyUtils.getPadraoNextID(getClass().hashCode());
	}
		
}
