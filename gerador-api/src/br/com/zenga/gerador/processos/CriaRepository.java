package br.com.suite.gerador.processos;

public class CriaRepository extends AnalisaArquivo {

	public CriaRepository(Object o) {
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
		return null;
	}

}
