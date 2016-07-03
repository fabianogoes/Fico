package br.com.fico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fico.models.Bank;
import br.com.fico.repositories.BankRepository;

@Service
public class BankService {

	private BankRepository bankRepository;

	@Autowired
	public void setBankRepository(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	public Bank save(Bank bank) {
		return this.bankRepository.save(bank);
	}

	public List<Bank> findAll() {
		return (List<Bank>) this.bankRepository.findAll();
	}

}
