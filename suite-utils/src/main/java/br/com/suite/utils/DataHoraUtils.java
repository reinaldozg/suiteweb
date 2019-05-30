package br.com.suite.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataHoraUtils {
	
	public static final Locale PT_BR = new Locale("pt", "BR");
	static final long ONE_MINUTE_IN_MILLIS=60000;
	
	public static Date getCurrentDate(){				
		return getCalendarInstanceBrasil().getTime();				
	}
	
	public static long getCurrentDateLong()	{
		SimpleDateFormat d =  new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(d.format(getCurrentDate()));
	}
		
	public static Date getDataAtualHoraZero(){
		Calendar c = Calendar.getInstance();
		c.setTime(getCurrentDate());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	public static Date getDataAtualUltimaHora(){
		Calendar c = Calendar.getInstance();
		c.setTime(getCurrentDate());
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}
	
	public static long diferenca(Date dataFim, Date dataInicio){
		if(dataInicio == null)
			return dataFim.getTime();
		else if(dataFim == null)
			throw new NullPointerException();
		
		return dataFim.getTime() - dataInicio.getTime();
	}

	public static Date getDate(long l) {
		return new Date(l);
	}
	
	
	public static Date getDataValidadeToken() {
		int validadeEmMinutos = 1440;
		Calendar c = getCalendarInstanceBrasil();
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
	
	private static Calendar getCalendarInstanceBrasil() {
		return Calendar.getInstance(PT_BR);
	}
}
