package br.com.suiteweb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.suite.entidades.EmpresaEntity;
import br.com.suiteweb.interfaces.ServiceCrud;
import br.com.suiteweb.repository.EmpresaRepository;

@Service
public class EmpresaService implements ServiceCrud<EmpresaEntity, String> {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void delete(EmpresaEntity empresa) {		
		EmpresaEntity empresaEntity = this.obter(empresa.getId());
		if (empresaEntity == null)
			return;
		
		empresa.setExcluido(true);
		empresaRepository.save(empresa);
	}

	@Override
	public EmpresaEntity obter(String id) {
		return empresaRepository.findOne(id);
	}
	
	@Override
	public List<EmpresaEntity> Lista() {
		return empresaRepository.findAll();
	}

	@Override
	public Page<EmpresaEntity> Lista(PageRequest page) {			
		return empresaRepository.findAll(page);
	}
	
	@Override
	public Page<EmpresaEntity> Lista(String parametro, PageRequest page) {			
		return empresaRepository.findByRazaoSocialLike(parametro, page);
	}
	
	@Override
	public EmpresaEntity salva(EmpresaEntity empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public List<EmpresaEntity> salva(List<EmpresaEntity> empresas) {
		for (EmpresaEntity empresa : empresas)
			this.salva(empresa);
		return empresas;
	}

	

	

}
