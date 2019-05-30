package br.com.suiteweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.suite.entidades.UnidadeEntity;
import br.com.suiteweb.interfaces.ServiceCrud;
import br.com.suiteweb.repository.UnidadeRepository;

@Service
public class UnidadeService implements ServiceCrud<UnidadeEntity, String>{

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Override
	public void delete(UnidadeEntity unidade) {
		UnidadeEntity unidadeEntity = this.obter(unidade.getId());
		if (unidadeEntity == null)
			return;
		
		unidade.setExcluido(true);
		unidadeRepository.save(unidade);		
	}

	@Override
	public UnidadeEntity obter(String id) {		
		return unidadeRepository.findOne(id);
	}

	@Override
	public List<UnidadeEntity> Lista() {		
		return unidadeRepository.findAll();
	}
	
	@Override
	public Page<UnidadeEntity> Lista(PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnidadeEntity salva(UnidadeEntity unidade) {
		return unidadeRepository.save(unidade);
	}

	@Override
	public List<UnidadeEntity> salva(List<UnidadeEntity> unidades) {
		for (UnidadeEntity unidade : unidades) {
			this.salva(unidade);
		}
		return unidades;
	}

	@Override
	public Page<UnidadeEntity> Lista(String paramLike, PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}
}
