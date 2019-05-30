package br.com.suiteweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import br.com.suite.entidades.EmpresaEntity;
import br.com.suiteweb.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@GetMapping
	public ModelAndView listar(
			@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "5") int porPagina, 
			@RequestParam(defaultValue = "razaoSocial") String ordenarPor,
			@RequestParam(defaultValue = "") String search) {				
		ModelAndView model = new ModelAndView("empresa/lista");			
		Page<EmpresaEntity> empresas = empresaService
				.Lista("%"+ search + "%",new PageRequest(pagina, porPagina, new Sort(Sort.Direction.ASC, ordenarPor)));

		int atualPagina = empresas.getNumber() + 1;
		int primeiraPagina = Math.max(1, empresas.getTotalPages() == pagina + 1?atualPagina - 4:atualPagina-3);
		int ultimaPagina = Math.min(primeiraPagina + 4, empresas.getTotalPages());

		model.addObject("empresas", empresas);
		model.addObject("primeiraPagina", primeiraPagina);
		model.addObject("atualPagina", atualPagina);
		model.addObject("ultimaPagina", ultimaPagina);
		model.addObject("porPagina", porPagina);
		model.addObject("msgResultInicio", ((porPagina * atualPagina) - porPagina) + 1);
		model.addObject("msgResultFim", ((empresas.getTotalElements()<porPagina)?empresas.getTotalElements(): porPagina * atualPagina));
		model.addObject("msgResultTotal", empresas.getTotalElements());
		model.addObject("search", search);
		
		return model;
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("empresa/novo");
		return mv;
	}	
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Validated EmpresaEntity empresa, Errors errors) {
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		if (errors.hasErrors()) {
			return mv;
		}

		return mv;
	}

}
