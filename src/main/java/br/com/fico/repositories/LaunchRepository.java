package br.com.fico.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fico.models.Launch;

@Repository
public interface LaunchRepository extends CrudRepository<Launch, Long> {

}
