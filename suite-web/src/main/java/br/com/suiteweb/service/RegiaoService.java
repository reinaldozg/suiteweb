package br.com.suiteweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.suite.entidades.RegiaoEntity;
import br.com.suiteweb.interfaces.ServiceCrud;
import br.com.suiteweb.repository.RegiaoRepository;

@Service
public class RegiaoService implements ServiceCrud<RegiaoEntity, String> {

	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Override
	public void delete(RegiaoEntity regiao) {
		RegiaoEntity regiaoEntity = this.obter(regiao.getId());
		if (regiaoEntity == null)
			return;
		
		regiao.setExcluido(true);
		regiaoRepository.save(regiao);		
	}

	@Override
	public RegiaoEntity obter(String id) {		
		return regiaoRepository.findOne(id);
	}

	@Override
	public List<RegiaoEntity> Lista() {
		return regiaoRepository.findAll();
	}
	
	@Override
	public Page<RegiaoEntity> Lista(PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegiaoEntity salva(RegiaoEntity regiao) {
		return regiaoRepository.save(regiao);
	}

	@Override
	public List<RegiaoEntity> salva(List<RegiaoEntity> regioes) {
		for (RegiaoEntity regiao : regioes) {
			this.salva(regiao);
		}
		return regioes;
	}

	@Override
	public Page<RegiaoEntity> Lista(String paramLike, PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}

}
