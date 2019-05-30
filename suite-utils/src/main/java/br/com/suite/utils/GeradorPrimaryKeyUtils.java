package br.com.suite.utils;

import java.io.IOException;

public class GeradorPrimaryKeyUtils {

	public static String getPadraoNextID(int hashCode) {
		try {
			String primaryKey = InfoSis.getHDSerial() + "Z" + hashCode + "V" + DataHoraUtils.getCurrentDateLong();
			return primaryKey.replace("-", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
