package br.com.suite.utils;

import java.text.ParseException;

public class ConvertUtils {

	public static long millisToSecond(long milis) {
		return milis / 1000;
	}

	public static String secondsToString(long pTime) {
		return millisToString(pTime * 1000);
	}

	public static String millisToString(long millis) {
		
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	public static String millisToStringSomada(long millis) {
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = millis / (1000 * 60 * 60);
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	
//	int segundos = 4567;
//	int segundo = segundos % 60;
//	int minutos = segundos / 60;
//	int minuto = minutos % 60;
//	int hora = minutos / 60;

	public static long horaFullToSeconds(String hora) throws ParseException {
		String strHora = hora.substring(0, hora.indexOf(":"));
		String strMinutos = hora.substring(hora.indexOf(":") + 1, hora.indexOf(":") + 3);
		String strSegundos = hora.substring(hora.lastIndexOf(":") + 1, hora.lastIndexOf(":") + 3);
		long segundos = (Long.parseLong(strHora) * 3600) + (Long.parseLong(strMinutos) * 60) + (Long.parseLong(strSegundos));
		return segundos;
	}
	
	public static long horaFullToMili(String hora){
		try{
			return horaFullToSeconds(hora)*1000;
		}catch(ParseException e){
			
		}
		return 0;
	}
}
