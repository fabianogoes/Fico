package br.com.fico.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fico.models.Lancamento;

@Controller
@RequestMapping("/lancamento")
public class LancamentoController {

	@RequestMapping("/new")
	public String getNew(Model model) {
		model.addAttribute("lancamento", new Lancamento());
		return "lancamento";
	}
}
