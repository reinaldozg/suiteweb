package br.com.suiteweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.suite.entidades.UsuarioEntity;
import br.com.suite.utils.BCryptUtil;
import br.com.suite.utils.DataHoraUtils;
import br.com.suiteweb.interfaces.ServiceCrud;
import br.com.suiteweb.repository.UsuarioRepository;

@Service
public class UsuarioService implements ServiceCrud<UsuarioEntity, String> {

	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Override
	public void delete(UsuarioEntity usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public UsuarioEntity obter(String id) {	
		return usuarioRepository.findOne(id);
	}

	@Override
	public List<UsuarioEntity> Lista() {
		return usuarioRepository.findAll();
	}

	@Override
	public Page<UsuarioEntity> Lista(PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UsuarioEntity salva(UsuarioEntity usuario) {

		UsuarioEntity usuarioEntity = usuario.getId() == null ? null : obter(usuario.getId());

		if (usuarioEntity == null) {
			usuario.setId(usuario.getPrimaryKey());
			usuario.setExcluido(false);
			usuario.setRestReset(null);
			usuario.setRestValidade(null);
			usuario.setSenha(BCryptUtil.encriptar(usuario.getSenha()));
			usuario.setDtAtualizacao(DataHoraUtils.getCurrentDate());

			return usuarioRepository.save(usuario);
		}

		usuarioEntity.setNome(usuario.getNome());
		usuarioEntity.setSobreNome(usuario.getSobreNome());

		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public List<UsuarioEntity> salva(List<UsuarioEntity> usuarios) {
		for (UsuarioEntity usuario : usuarios)
			this.salva(usuario);
		return usuarios;
	}

	public UsuarioEntity obterPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Page<UsuarioEntity> Lista(String paramLike, PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
