package br.com.fico.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fico.models.Bank;
import br.com.fico.services.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankRestController {

	private BankService bankService;

	@Autowired
	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Bank> get() {
		return bankService.findAll();
	}

}
