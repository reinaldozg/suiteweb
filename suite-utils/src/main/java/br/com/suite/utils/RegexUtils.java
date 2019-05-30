package br.com.suite.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {			
			
	public static String camelCaseToSomething(String camelCase, String to){
		String regex = "([a-z])([A-Z])";
        String replacement = "$1"+to+"$2";     
        return camelCase.replaceAll(regex, replacement); 
	}
	
	public static String primeiraLetraMaiuscula(String str){      
		  return (str.charAt(0)+ "").toUpperCase() + str.substring(1);
	}
	
	public static String primeiraLetraMinuscula(String str){      
		  return (str.charAt(0)+ "").toLowerCase() + str.substring(1);
	}
	
	public static String proximaDescricao(String descricao){
		Pattern pattern = Pattern.compile("\\d+");		
		Matcher math = pattern.matcher(descricao);
		
		while (math.find()){			
			String strNumero = descricao.substring(math.start(), math.end());
			String patternZerosEsquerda = "%0"+strNumero.length()+"d";			
			Integer numero = Integer.parseInt(strNumero);
			numero = numero + 1;
			descricao = descricao.replaceAll(strNumero, String.format(patternZerosEsquerda, numero));			
		}		
		
		return descricao;
	}
	
	public static int getNumeroDoRotulo(String descricao){
		Pattern pattern = Pattern.compile("\\d+");		
		Matcher math = pattern.matcher(descricao);
		
		if (math.find()){			
			String strNumero = descricao.substring(math.start(), math.end());
			Integer numero = Integer.parseInt(strNumero);		
			return numero;
		}		
		return 0;
	}
}