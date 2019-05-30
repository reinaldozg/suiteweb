package br.com.suite.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import static br.com.suite.utils.ObjectsUtils.isNullOrEmpty;
import static br.com.suite.utils.ObjectsUtils.isNull;

public class DataUtils {
	
	public static final Locale PT_BR = new Locale("pt", "BR");
	static final long ONE_MINUTE_IN_MILLIS=60000;
	
	public static Date getCurrentDate(){				
		return getCalendarInstanceBrasil().getTime();				
	}

	private static Calendar getCalendarInstanceBrasil() {
		return Calendar.getInstance(PT_BR);
	}
	
	public static Date getDataAtual() {
		return Calendar.getInstance().getTime();
	}

	public static Date getDataValidadeToken() {
		int validadeEmMinutos = 1440;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, validadeEmMinutos);
		return c.getTime();
	}
	
	public static String getDataShortFormatada(long data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
	
	public static String getDataLongFormatada(long data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		return sdf.format(data);
	}
	
	
	public static String dateToString(Date data, String formato){
		SimpleDateFormat sdf = getSimpleDateFormatBrasil(formato);
		return sdf.format(data);
	}

	private static SimpleDateFormat getSimpleDateFormatBrasil(String formato) {
		return new SimpleDateFormat(formato, PT_BR);
	}
	
	public static Date strToDate(String strData, String formato) {
		SimpleDateFormat format = getSimpleDateFormatBrasil(formato);
		try {
			if (!isNullOrEmpty(strData) && !isNullOrEmpty(formato)) {
				Date data;
				data = (Date) format.parse(strData);
				return data;
			}
		} catch (ParseException e) {
			System.out.println("Erro ao formatar data: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retrocede o total de dias passado pelo parametro diasRetroceder, a partir
	 * da dataAtual
	 * 
	 * @param diasRetroceder
	 * @param dataAtual
	 * @return Date
	 */
	public static Date retrocederDiaData(Integer diasRetroceder, Date dataAtual) {
		return retrocederData(diasRetroceder, Calendar.DAY_OF_MONTH, dataAtual);
	}
	
	/**
	 * Retrocede o total de dias passado pelo parametro diasRetroceder, a partir
	 * da dataAtual
	 * 
	 * @param diasRetroceder
	 * @param dataAtual
	 * @return Date
	 */
	public static Date retrocederHoraData(Integer horasRetroceder, Date dataAtual) {
		return retrocederData(horasRetroceder, Calendar.HOUR_OF_DAY, dataAtual);
	}
	
	public static Date retrocederData(Integer valor, Integer campoDoCalendario, Date dataAtual){
		Calendar calendar = getGregorianCalendarInstanceBrasil();
		calendar.setTime(dataAtual);
		Integer diaAtual = calendar.get(campoDoCalendario);
		calendar.set(campoDoCalendario, (diaAtual - valor));
		return calendar.getTime();
	}

	private static Calendar getGregorianCalendarInstanceBrasil() {
		return GregorianCalendar.getInstance(PT_BR);
	}

	/**
	 * Adianta o total de dias passado pelo parametro diasAdiantar, a partir
	 * da dataAtual
	 * 
	 * @param diasAdiantar
	 * @param dataAtual
	 * @return Date
	 */
	public static Date adiantarDiaData(Integer diasAdiantar, Date dataAtual) {
		return adiantarData(diasAdiantar, Calendar.DAY_OF_MONTH, dataAtual);
	}
	
	/**
	 * Adianta o valor sobre o par�metro do calend�rio a partir da data atual. Exemplo: 5 dias ou 12 meses ou 2 anos.
	 * 
	 *  @param valor Quantidade
	 *  @param campoDoCalendario Par�metros da classe {@link Calendar}
	 *  @param dataAtual Data atual
	 * */
	public static Date adiantarData(Integer valor, Integer campoDoCalendario, Date dataAtual){
		Calendar calendar = getGregorianCalendarInstanceBrasil();
		calendar.setTime(dataAtual);
		Integer diaAtual = calendar.get(campoDoCalendario);
		calendar.set(campoDoCalendario, (diaAtual + valor));
		return calendar.getTime();
	}
	
	/**
	 * Adianta o total de horas passado pelo parametro horasAdiantar, a partir
	 * da dataAtual
	 * 
	 * @param horasAdiantar
	 * @param dataAtual
	 * @return Date
	 */
	public static Date adiantarHoraData(Integer horasAdiantar, Date dataAtual) {
		return adiantarData(horasAdiantar, Calendar.HOUR_OF_DAY, dataAtual);
	}
	
	/**
	 * Valida se data1 � maior que data2.
	 * 
	 * @param data1 
	 * @param data2
	 * 
	 * @return boolean
	 * */
	public static boolean isDataMaiorQue(Date data1, Date data2){
		if(data1.after(data2)){
			return true;
		}
		return false;
	}
	
	/**
	 * Captura o dia da semana atual
	 * */
	public static int getDiaDaSemana(Date data){
		Calendar c = getCalendarInstanceBrasil();
		c.setTimeInMillis(data.getTime());
		
		int ano = c.get(Calendar.YEAR);
		int mes = c.get(Calendar.MONTH);
		int dia = c.get(Calendar.DAY_OF_MONTH);
		
		Calendar calendario = new GregorianCalendar(ano, mes, dia);  
	    int diaSemana = calendario.get(Calendar.DAY_OF_WEEK); 
		
		return diaSemana - 1;
	}
	
	public static String segundosToHorasStr(long segundos){
		long minutos = segundos / 60;   
		long minuto = minutos % 60;   
		long hora = minutos / 60;   
		String hms = "";
		if(hora > 0){
			hms = String.format ("%02dh%02d", hora, minuto);
		}else{
			hms = String.format ("%02dm", minuto);
		}
		return hms;
	}
	
	/**
	 * Retorna data com a hora 00:00:00.
	 * 
	 * @param data
	 * @return {@link Date}
	 * */
	public static Date getDataComZeroHora(Date data) {
		return DataUtils.setHoraNaData(data, 0, 0, 0);
	}
	
	/**
	 * Retorna data com a hora 23:59:59.
	 * 
	 * @param data
	 * @return {@link Date}
	 * */
	public static Date getDataComUltimaHora(Date data) {
		return DataUtils.setHoraNaData(data, 23, 59, 59);
	}
	/**
	 * Adianta a data a 15 min a frente
	 * 
	 * @param data
	 * @return {@link Date}
	 * */
	public static Date atrazarQuinzeMin(Date data){
		Calendar calendar = getGregorianCalendarInstanceBrasil();
		calendar.setTime(data);
		long t = calendar.getTimeInMillis();
		Date afterAddingMins = new Date(t-(15*ONE_MINUTE_IN_MILLIS));
		return afterAddingMins;
	}
	private static Date setHoraNaData(Date data, int hora, int minuto, int segundo){
		if(isNull(data)) return null;
		
		Calendar c = getCalendarInstanceBrasil();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minuto);
		c.set(Calendar.SECOND, segundo);
		return c.getTime();
	}

	public static long calculaTempoEstadoCom(Date data1,Date data2) {
		long tempoAtual = data1.getTime();
		return tempoAtual - data2.getTime();
	}
	
	public static String millisToString(long millis) {
		
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}
