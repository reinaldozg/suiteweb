package br.com.suiteweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.suite.entidades.UsuarioEntity;
import br.com.suiteweb.service.UsuarioService;

@RestController
@RequestMapping("/layout")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ThemeController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public ModelAndView layout(@RequestParam("username") String username) {

		UsuarioEntity usuario = usuarioService.obterPorEmail(username);
		ModelAndView model = new ModelAndView("redirect:layout/tema");

		if (usuario == null) {
			model.addObject("themeName", "default");
		} else {
			model.addObject("themeName", usuario.getLayout().getTema());
		}

		return model;
	}

	@GetMapping("/tema")
	public ModelAndView tema(@RequestParam("themeName") String themeName) {
		return new ModelAndView("redirect:/home");
	}

}
