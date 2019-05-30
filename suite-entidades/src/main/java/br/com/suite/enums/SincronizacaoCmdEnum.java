package br.com.suite.enums;

public enum SincronizacaoCmdEnum {

	INSERIR(1), ALTERAR(2), EXCLUIR(3);

	private int valor;

	public int getValor() {
		return valor;
	}

	SincronizacaoCmdEnum(int valor) {
		this.valor = valor;
	}
}
