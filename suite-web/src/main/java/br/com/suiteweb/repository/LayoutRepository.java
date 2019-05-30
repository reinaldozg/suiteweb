package br.com.suiteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.suite.entidades.LayoutEntity;

@Repository
public interface LayoutRepository extends JpaRepository<LayoutEntity, String>{

}
