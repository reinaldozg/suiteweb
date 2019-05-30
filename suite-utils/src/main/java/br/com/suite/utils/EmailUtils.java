package br.com.suite.utils;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailConstants;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmailUtils {
	private static final Logger log = LoggerFactory.getLogger(Email.class.getName());
	
	
	public static void enviar(String body, String smtp, List<String> contatosParaEnviar, String from, String password, String userFromDisplayName, String subject, String smtpPort) {
		HtmlEmail email;
		try {
			email = new HtmlEmail();
			email.setHostName(smtp);
			email.setSmtpPort(Integer.valueOf(smtpPort));
			email.setAuthenticator(new DefaultAuthenticator(from, password));
			email.setFrom(from, userFromDisplayName);
			
			for (String contato : contatosParaEnviar)
				email.addTo(contato);
			email.setSubject(subject);
			email.setContent(body, EmailConstants.TEXT_HTML);
			email.send();
		} catch (EmailException e) {
			log.error("Falha ao enviar email: ", e);
		}
	}
}
