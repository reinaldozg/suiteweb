package br.com.suiteweb.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.suite.entidades.UsuarioEntity;
import br.com.suiteweb.service.UsuarioService;

@RestController
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class AcessoController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public ModelAndView entrar(Principal principal) {
		ModelAndView model = new ModelAndView("redirect:layout");
		model.addObject("username",principal.getName());
		return model;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();		
		model.setViewName("acesso/login");		
		return model;
	}
	
	@GetMapping("/login/failed")
	public ModelAndView failed() {
		ModelAndView model = new ModelAndView();		
		model.setViewName("acesso/login");	
		model.setStatus(HttpStatus.UNAUTHORIZED);
		model.addObject("error", true);
		return model;
	}
	
	@GetMapping("/acesso/inscricao")
	public ModelAndView inscricao() {
		ModelAndView model = new ModelAndView();
		model.setViewName("acesso/inscricao");
		return model;
	}

	@PostMapping("/acesso/inscricao")
	public ModelAndView criarAcesso(UsuarioEntity usuario) {

		usuarioService.salva(usuario);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/home");
		return model;
	}

	@GetMapping("/acesso/recuperar/senha")
	public ModelAndView recuperar() {
		ModelAndView model = new ModelAndView();
		model.setViewName("acesso/recuperar");
		return model;
	}

	@PostMapping("/acesso/recuperar/senha")
	public ModelAndView recuperaSenha(@RequestParam("email") String email) {
		ModelAndView mv = new ModelAndView("acesso/login");
		if(email==null || email.isEmpty()) {
			return mv;
		}
		
	
		return mv;
	}
	
}
