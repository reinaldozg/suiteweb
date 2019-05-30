package br.com.suite.gerador.processos;

public class CriaController extends AnalisaArquivo {
	
	public CriaController(Object o) {
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
