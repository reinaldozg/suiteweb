package br.com.suite.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.suite.enums.SincronizacaoCmdEnum;

@Entity
@Table(name = "sincronizacao_log")
public class LogSincronizacaoEntity  implements Comparable<LogSincronizacaoEntity>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private SincronizacaoCmdEnum comando;
	
	@Column(name = "objson", length = 10000)
	private String obJson;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SincronizacaoCmdEnum getComando() {
		return comando;
	}

	public void setComando(SincronizacaoCmdEnum comando) {
		this.comando = comando;
	}

	public String getObJson() {
		return obJson;
	}

	public void setObJson(String obJson) {
		this.obJson = obJson;
	}

	@Override
	public int compareTo(LogSincronizacaoEntity log) {
		if (this.id > log.getId()) {
			return 1;
		}

		if (this.id < log.getId()) {
			return -1;
		}
		return 0;
	}
}
