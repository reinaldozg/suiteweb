package br.com.suite.utils;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestUtils {

	private static Logger logger = LoggerFactory.getLogger(RestUtils.class);	

	public static <E> List<E> doGet(String url, GenericType<List<E>> genericType) {
		List<E> resultado = null;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		Response response = target.request().buildGet().invoke();

		if (checkStatus(response)) {
			resultado = response.readEntity(genericType);
		}

		client.close();

		return resultado;
	}

	public static <E> E doGet(String url, Class<E> classeRetorno) {
		return doGet(url, classeRetorno, MediaType.APPLICATION_JSON);
	}
	
	public static <E> E doGet(String url, Class<E> classeRetorno, String... mediaType){
		E resultado = null;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		Response response = target.request().accept(mediaType).buildGet().invoke();

		if (checkStatus(response)) {				
			resultado = response.readEntity(classeRetorno);			
		}

		client.close();

		return resultado;
	}

	public static boolean doPost(String url, Object param) {
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request().buildPost(Entity.entity(param, MediaType.APPLICATION_JSON)).invoke();
		return checkStatus(response);
	}
	
	public static <E> E doPost(String url, Class<E> classeRetorno, Object param) {
		E resultado = null;
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request()
				.buildPost(Entity.entity(param, MediaType.APPLICATION_JSON)).invoke();
		if (checkStatus(response)) {				
			resultado = response.readEntity(classeRetorno);			
		}

		client.close();

		return resultado;
	}
	
	private static boolean checkStatus(Response response) {
		if (response.getStatus() == 200) {
			return true;
		} else {
			logger.error("ERRO");
			return false;
		}

	}
}
