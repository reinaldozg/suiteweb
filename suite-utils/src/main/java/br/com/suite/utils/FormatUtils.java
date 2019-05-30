package br.com.suite.utils;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class FormatUtils {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DecimalFormat numberFormater;
	private static NumberFormat moneyFormater;
	private static NumberFormat percentageFormatter;
	
	static{
		Locale ptBR = new Locale("pt", "BR");
		DecimalFormatSymbols decimalFormatter = new DecimalFormatSymbols();
		decimalFormatter.setCurrency(Currency.getInstance(ptBR));
		decimalFormatter.setDecimalSeparator(',');
		decimalFormatter.setGroupingSeparator('.');
		numberFormater = new DecimalFormat("###,###.##", decimalFormatter);
		moneyFormater = DecimalFormat.getCurrencyInstance(ptBR);
		percentageFormatter = NumberFormat.getPercentInstance(ptBR);
		percentageFormatter.setMinimumFractionDigits(1);
	}
	
	public static String formatDate(final Date date){
		if(date == null)
			return "";
		return sdf.format(date);
	}
	
	public static String formatNumber(final BigDecimal number){
		return numberFormater.format(number.doubleValue());
	}
	
	public static String formatNumber(final double value){
		return numberFormater.format(value);
	}
	
	public static String formatValorMonetario(final BigDecimal value){
		if(value != null)
			return moneyFormater.format(value);
		else
			return formatValorMonetario(0D);
	}
	
	public static BigDecimal cashToDouble(final String amount, final Locale locale) throws ParseException {
	    final NumberFormat format = NumberFormat.getNumberInstance(locale);
	    if (format instanceof DecimalFormat) {
	        ((DecimalFormat) format).setParseBigDecimal(true);
	    }
	    return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]",""));
	}
	
	public static BigDecimal formatDoubleFromValorMonetario(final String value){
		try{
			return cashToDouble(value,new Locale("pt", "BR"));
		}
		catch(ParseException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String formatValorMonetario(final double value){
		return moneyFormater.format(value);
	}
	
	public static String formatPorcentagem(final float valor){
		return percentageFormatter.format(valor);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    return new BigDecimal(value).setScale(places, HALF_UP).doubleValue();
	}
	
	public static String formatPorcentagemStringDuasCasas(final double value){
		return format("%.2f", value).concat("%");
	}
	
	public static String formatPorcentagemStringSemCasas(final double value){
		return format("%.0f", value).concat("%");
	}
}
