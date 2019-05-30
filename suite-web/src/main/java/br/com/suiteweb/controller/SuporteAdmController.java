package br.com.suiteweb.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/suporte")
@PreAuthorize("hasRole('ROLE_SUPORTE')")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class SuporteAdmController {

	
	@GetMapping("/buscar")
	public ModelAndView securedHello() {
		ModelAndView model = new ModelAndView();
		model.setViewName("suporte-adm/menu/buscar");		
		return model;
	}
	
	
}
