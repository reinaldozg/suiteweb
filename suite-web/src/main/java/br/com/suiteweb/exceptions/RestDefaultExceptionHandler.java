package br.com.suiteweb.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestControllerAdvice
public class RestDefaultExceptionHandler extends ResponseEntityExceptionHandler {

	private Log logger = LogFactory.getLog(RestDefaultExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.error("Request -->: " + request.getContextPath(), ex);

		StringBuilder builder = new StringBuilder();
		ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

		MensagemErro errorMessage = new MensagemErro("Método de solicitação não é suportado.");
		errorMessage.setPath(request.getContextPath());
		errorMessage.setAlternativa(builder.toString());

		return new ResponseEntity<>(errorMessage, status);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		logger.error("Request -->: " + request.getContextPath(), ex);

		Map<String, String> parametrosErro = new HashMap<String, String>();
		ex.getFieldErrors().forEach(e -> {
			parametrosErro.put(e.getField(), e.getRejectedValue().toString());
		});

		MensagemErro errorMessage = new MensagemErro(
				"Parametro obrigatório não informado ou o tipo de dados está incorreto");
		errorMessage.setPath(request.getContextPath());
		errorMessage.setParametros(parametrosErro);

		return new ResponseEntity<>(errorMessage, status);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		Map<String, String> parametrosErro = new HashMap<String, String>();

		parametrosErro.put(ex.getValue().toString(), ex.getRequiredType().toString());

		MensagemErro errorMessage = new MensagemErro("Erro ao tentar converter os dados");
		errorMessage.setPath(request.getContextPath());
		errorMessage.setParametros(parametrosErro);

		return new ResponseEntity<>(errorMessage, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		MensagemErro mensagemErro = new MensagemErro("O corpo de sua requisição não pode ser vazio.");
		mensagemErro.setPath(request.getContextPath());

		return new ResponseEntity<>(mensagemErro, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		MensagemErro mensagemErro = new MensagemErro(
				"O tipo de mídia não é suportado: " + ex.getLocalizedMessage());

		StringBuilder alternativa = new StringBuilder();
		ex.getSupportedMediaTypes().forEach(t -> alternativa.append(t + ", "));
		mensagemErro.setAlternativa(alternativa.toString());

		mensagemErro.setPath(request.getContextPath());		

		return new ResponseEntity<>(mensagemErro, status);

	}
		
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		
//		MensagemErro errorMessage = new MensagemErro(
//				"Parametro obrigatório não informado ou o tipo de dados está incorreto");
//		errorMessage.setPath(request.getContextPath());
//		errorMessage.setParametros(parametrosErro);
//
//		return new ResponseEntity<>(errorMessage, status);
//		
		
		return new ResponseEntity<>(new MensagemErro("handleMissingPathVariable"), status);
	}
	

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException arg0,
			HttpHeaders arg1, HttpStatus arg2, WebRequest arg3) {
		return new ResponseEntity<>(new MensagemErro("handleAsyncRequestTimeoutException"), HttpStatus.REQUEST_TIMEOUT);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleConversionNotSupported"), status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleHttpMediaTypeNotAcceptable"), status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleHttpMessageNotWritable"), status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleMethodArgumentNotValid"), status);
	}

	

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleMissingServletRequestPart"), status);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleServletRequestBindingException"), status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleMissingServletRequestParameter"), status);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleExceptionInternal"), status);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new MensagemErro("handleNoHandlerFoundException"), status);
	}
	
}

@JsonInclude(Include.NON_NULL)
class MensagemErro {

	private Date data = new Date();
	private String path = null;

	private String mensagem;
	private Map<String, String> parametros = null;
	private String alternativa = null;

	public MensagemErro(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public Map<String, String> getParametros() {
		return parametros;
	}

	public void setParametros(Map<String, String> parametros) {
		this.parametros = parametros;
	}

}
