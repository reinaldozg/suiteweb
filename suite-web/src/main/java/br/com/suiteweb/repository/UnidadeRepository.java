package br.com.suiteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.suite.entidades.UnidadeEntity;

@Repository
public interface UnidadeRepository extends JpaRepository<UnidadeEntity, String> {
	


}
