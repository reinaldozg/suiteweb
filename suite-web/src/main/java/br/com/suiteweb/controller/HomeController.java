package br.com.suiteweb.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class HomeController {


	// @PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping()
	public ModelAndView index() {
		return new ModelAndView("home/index");
	}

	
	// @PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping()
	@RequestMapping("/editar")
	public ModelAndView editar() {
		ModelAndView model = new ModelAndView("cliente/editar");
		return model;
	}
	
}
