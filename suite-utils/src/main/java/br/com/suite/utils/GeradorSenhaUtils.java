package br.com.suite.utils;

public class GeradorSenhaUtils {

	private static String[] CARACT_ALFANUMERICO = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
			"d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
			"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z" };

	public static String getSenhaAlfanumericaAleatoria() {
		String senha = "";
		for (int x = 0; x < 8; x++) {
			int j = (int) (Math.random() * CARACT_ALFANUMERICO.length);
			senha += CARACT_ALFANUMERICO[j];
		}
		return senha;
	}

	public static String getRestRecuperacaoSenha() {
		String rest = "";
		for (int x = 0; x < 16; x++) {
			rest += getSenhaAlfanumericaAleatoria();
		}
		return rest;
	}
}
