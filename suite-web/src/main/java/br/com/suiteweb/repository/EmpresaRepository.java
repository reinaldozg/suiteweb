package br.com.suiteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.suite.entidades.EmpresaEntity;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, String>{

	Page<EmpresaEntity> findByRazaoSocialLike(String razaoSocial, Pageable pageable);
	
}
