package br.com.suiteweb.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import br.com.suiteweb.repository.UsuarioRepository;
import br.com.suiteweb.service.AcessoService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true)
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements AuthenticationFailureHandler {

//	private static final Logger log = Logger.getLogger(WebSecurityConfig.class);
	
	
	 @Autowired
	 private AcessoService acessoService;

	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		 auth.userDetailsService(acessoService).passwordEncoder(new	BCryptPasswordEncoder());
	 }

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests()
				.antMatchers("/static/**").permitAll()
				.antMatchers("/login/failed").permitAll()
//				.antMatchers("/acesso/inscricao").permitAll()
//				.antMatchers("/acesso/recuperar/senha/suite").permitAll()				
				.anyRequest()
			.authenticated()
			
			.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")			
					.failureHandler(new WebSecurityConfig()).permitAll()
					.and().requiresChannel().antMatchers("/**").requiresSecure()
			.and()
				.logout()					
				.logoutSuccessUrl("/login?logout")	
			.and()
				.rememberMe()
					.rememberMeCookieName("app-remember-me")
					.tokenValiditySeconds((24 * (60 * 60)))
				.userDetailsService(acessoService) ;
		
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {					
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.sendRedirect(request.getContextPath() + "/login/failed?error=true");
				
	}
}
