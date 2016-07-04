package br.com.fico.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fico.models.Lancamento;
import br.com.fico.services.LancamentoService;

@RestController
@RequestMapping("/api/launch")
public class LaunchRestController {

	private LancamentoService lancamentoService;

	@Autowired
	public void setLancamentoService(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}

	@RequestMapping
	public List<Lancamento> get() {
		System.out.println("get( )");
		return lancamentoService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Lancamento create(@RequestBody Lancamento lancamento) {
		System.out.println("post( " + lancamento + " )");
		return lancamentoService.save(lancamento);
	}

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		System.out.println("delete( " + id + " )");
		HttpStatus statusCode = HttpStatus.OK;
		try {
			this.lancamentoService.delete(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(statusCode);
	}

	@RequestMapping(value = "/{id}")
	public Lancamento get(@PathVariable Long id) {
		System.out.println("get( " + id + " )");
		return this.lancamentoService.findOne(id);
	}
	
	@RequestMapping(value = "/pay/{id}")
	public ResponseEntity<String> pay(@PathVariable Long id) {
		System.out.println("pay( " + id + " )");
		HttpStatus statusCode = HttpStatus.OK;
		try {
			this.lancamentoService.pay(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(statusCode);
	}

}
