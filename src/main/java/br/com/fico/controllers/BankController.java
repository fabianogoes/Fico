package br.com.fico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fico.models.Bank;
import br.com.fico.services.BankService;

@Controller
@RequestMapping("/bank")
public class BankController {

	private BankService bankService;

	@Autowired
	private void setBankService(BankService bankService){
		this.bankService = bankService;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(Bank bank, String nextUrl, Model model){
		
		Bank bankSave = this.bankService.save( bank );
		model.addAttribute("bank", bankSave);
		
		if( nextUrl != null ){
			return "redirect:"+nextUrl;
		}
		
		return "bank";
	}
	
}
