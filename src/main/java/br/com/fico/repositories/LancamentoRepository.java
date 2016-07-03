package br.com.fico.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fico.models.Lancamento;

@Repository
public interface LancamentoRepository extends CrudRepository<Lancamento, Long> {

}
