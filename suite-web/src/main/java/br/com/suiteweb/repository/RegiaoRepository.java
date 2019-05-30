package br.com.suiteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.suite.entidades.RegiaoEntity;

@Repository
public interface RegiaoRepository extends JpaRepository<RegiaoEntity, String>{

}
