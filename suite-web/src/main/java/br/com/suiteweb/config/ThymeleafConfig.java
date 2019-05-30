package br.com.suiteweb.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.theme.SessionThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@EnableWebMvc
@Configuration
@ComponentScan({ "br.com.suiteweb.controller" })
@EntityScan(basePackages = { "br.com.suite.entidades" })
public class ThymeleafConfig extends WebMvcConfigurerAdapter {

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
		templateEngine.addDialect(new LayoutDialect());
		templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Bean
	public SpringResourceTemplateResolver thymeleafTemplateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setCacheable(false);
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setPrefix("classpath:/templates/WEB-INF/paginas/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}

	@Bean
	public ThemeSource themeSource() {
		ResourceBundleThemeSource source = new ResourceBundleThemeSource();
		source.setBasenamePrefix("static.themes.theme-");
		return source;
	}

	@Bean
	public ThemeResolver themeResolver() {
		SessionThemeResolver resolver = new SessionThemeResolver();
		resolver.setDefaultThemeName("default");
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
		themeChangeInterceptor.setParamName("themeName");
		registry.addInterceptor(themeChangeInterceptor);
		 
	}

}
