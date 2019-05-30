package br.com.suiteweb.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.suite.entidades.UsuarioEntity;

@Service
public class AcessoService extends UsuarioService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		UsuarioEntity usuario = usuarioRepository.findByEmail(login);
		if (usuario == null)
			throw new UsernameNotFoundException("Usuario não encontrado");
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
	}
}
