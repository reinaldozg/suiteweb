package br.com.suite.gerador.processos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.suite.gerador.interfaces.IProcesso;
import br.com.suite.gerador.staticos.Marcador;

public abstract class AnalisaArquivo implements IProcesso {

	protected Object o;

	public AnalisaArquivo(Object o) {
		this.o = o;
	}

	@Override
	public void executa() throws Exception {

		System.out.println("Criando arquivo :" + getDiretorioDestino());

		File arquivoOrigem = new File(getDiretorioOrigem());
		File arquivoDestino = new File(getDiretorioDestino());

		File parent = arquivoDestino.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}

		if (arquivoDestino.exists()) {
			throw new Exception("O projeto já possui o arquivo :" + getDiretorioDestino());
		}

		arquivoDestino.createNewFile();

		FileWriter escritor = new FileWriter(arquivoDestino, true);

		try {

			FileReader arquivo = new FileReader(arquivoOrigem);
			BufferedReader br = new BufferedReader(arquivo);
			String linha = br.readLine();

			while (linha != null) {

				if (linha.contains(Marcador.INICIO_DA_IMPLEMENTACAO_DA_CLASSE))
					linha = montaImplementacao();

				escritor.append(substituiPalavraChave(linha));

				linha = br.readLine();
			}

			br.close();
			arquivo.close();
			escritor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String substituiPalavraChave(String texto) {

		System.out.println("Substituindo palavras chave...");

		return texto;
	}

	protected abstract String montaImplementacao();

	protected abstract String getDiretorioOrigem();

	protected abstract String getDiretorioDestino();

}
