package br.com.fico.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping
	public String index(Model model) {
		model.addAttribute("module", "dash");
		return "index";
	}

	@RequestMapping("/launch")
	public String getNew(Model model) {
		model.addAttribute("module", "launch");
		return "launch";
	}
}
