package br.com.suite.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ObjectsUtils {

	public static boolean containsTotallyEqual(final List<Object> handledObjects, final Object value) {
		for(Object obj : handledObjects){
			if(!obj.equals(value) && obj != value)
				return false;
		}
		return true;
	}
	
	public static boolean isNullOrEmpty(final Collection<?> lista){
		return lista == null || lista.isEmpty();
	}
	
	public static boolean isNullOrEmpty(final String string){
		return string == null || string.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<?,?> mapa) {
		return mapa == null || mapa.isEmpty();
	}

	public static boolean isNull(Object e) {
		return e == null;
	}
}
