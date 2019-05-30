package br.com.suite.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	/**
	 * Criptografa o valor informado utilizando a classe BCryptPasswordEncoder.
	 * 
	 * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
	 * @param valor O valor que será ciptografado.
	 * @return O valor criptografado.
	 */
	public static String encriptar(final String valor) {
		return encoder.encode(valor);
	}
	
	/**
	 * Utilizando os critérios de encriptação de BCryptPasswordEncoder,
	 * verifica se os valores informados são os mesmos.
	 * 
	 * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
	 * @param valor O valor sem criptografia.
	 * @param criptografado O valor criptografado.
	 * @return true se o valor sem criptografia é igual ao valor
	 * criptografado, ou false caso contrário.
	 */
	public static boolean isValido(String valor, String criptografado) {
		return encoder.matches(valor, criptografado);
	}
}
