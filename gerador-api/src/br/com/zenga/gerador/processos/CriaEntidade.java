package br.com.suite.gerador.processos;

public class CriaEntidade extends AnalisaArquivo {

	public CriaEntidade(Object o) {
		super(o);
	}

	@Override
	protected String montaImplementacao() {

		return null;
	}

	@Override
	protected String getDiretorioOrigem() {
		return "arquivos/modelo-classes/repositorio-modelo.java";
	}

	@Override
	protected String getDiretorioDestino() {
		// TODO Auto-generated method stub
		return null;
	}

}
