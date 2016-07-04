package br.com.fico.services;

import java.util.List;

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

	public List<Lancamento> findAll() {
		return (List<Lancamento>) this.lancamentoRepository.findAll();
	}

	public void delete(Long id) {
		this.lancamentoRepository.delete(id);
	}

	public Lancamento findOne(Long id) {
		return this.lancamentoRepository.findOne(id);
	}

	public void pay(Long id) {
		Lancamento lancamento = this.findOne(id);
		boolean pay = !lancamento.getPaid(); 
		lancamento.setPaid(pay);
		this.save(lancamento);
	}

}
