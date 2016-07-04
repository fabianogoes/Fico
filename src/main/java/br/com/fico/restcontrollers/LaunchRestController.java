package br.com.fico.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(method = RequestMethod.POST)
	public Lancamento post(@RequestBody Lancamento lancamento) {
		//throw new NotImplementedException( "not implemented" );
		System.out.println( "post( "+lancamento+" )" );
		return lancamentoService.save(lancamento);
	}

}
