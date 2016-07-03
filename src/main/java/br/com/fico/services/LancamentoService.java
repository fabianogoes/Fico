package br.com.fico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fico.models.Lancamento;
import br.com.fico.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	private LancamentoRepository lancamentoRepository;

	@Autowired
	public void setLancamentoRepository(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}

	public Lancamento save(Lancamento lancamento) {
		return this.lancamentoRepository.save(lancamento);
	}

}
