package br.com.suite.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_layout")
public class LayoutEntity {
	
	@Id
	private int id;		
	@Column(length=20)
	private String tema;	
	@Column(length=7)
	private String paletaHexa;	
	private boolean ativa;
			
	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPaletaHexa() {
		return paletaHexa;
	}
	
	public void setPaletaHexa(String paletaHexa) {
		this.paletaHexa = paletaHexa;
	}
	
	public boolean isAtiva() {
		return ativa;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}	
	
	

}
