package br.com.fico.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fico.models.Launch;
import br.com.fico.repositories.LaunchRepository;

@Service
public class LaunchService {

	private LaunchRepository lancamentoRepository;

	@Autowired
	public void setLancamentoRepository(LaunchRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}

	public Launch save(Launch lancamento) {
		Calendar doneDate = lancamento.getDone() ? Calendar.getInstance() : null;
		lancamento.setDoneDate(doneDate);		
		return this.lancamentoRepository.save(lancamento);
	}

	public List<Launch> findAll() {
		return (List<Launch>) this.lancamentoRepository.findAll();
	}

	public void delete(Long id) {
		this.lancamentoRepository.delete(id);
	}

	public Launch findOne(Long id) {
		return this.lancamentoRepository.findOne(id);
	}

	public void pay(Long id) {
		Launch lancamento = this.findOne(id);
		boolean done = !lancamento.getDone(); 
		lancamento.setDone(done);
		Calendar doneDate = done ? Calendar.getInstance() : null;
		lancamento.setDoneDate(doneDate);
		this.save(lancamento);
	}

}
