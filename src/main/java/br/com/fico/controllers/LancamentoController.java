package br.com.fico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fico.models.Bank;
import br.com.fico.models.Lancamento;
import br.com.fico.services.BankService;
import br.com.fico.services.LancamentoService;

@Controller
@RequestMapping("/lancamento")
public class LancamentoController {

	private BankService bankService;
	private LancamentoService lancamentoService;

	@Autowired
	public void setLancamentoService(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}

	@Autowired
	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	@RequestMapping("/new")
	public String getNew(Model model) {
		List<Bank> banks = this.bankService.findAll();
		model.addAttribute("banks", banks);
		model.addAttribute("lancamento", new Lancamento());
		return "lancamento";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String post(Lancamento lancamento, String paidText, Model model) {
		try{
			lancamento.setPaid( "on".equals(paidText) );
			this.lancamentoService.save(lancamento);
			model.addAttribute("alertStatus", "success");
			model.addAttribute("alertMessage", "Lançamento salvo com sucesso!");
		}catch(RuntimeException e){
			model.addAttribute("alertStatus", "danger");
			model.addAttribute("alertMessage", e.getMessage());
		}
		return "lancamento";
	}

}
