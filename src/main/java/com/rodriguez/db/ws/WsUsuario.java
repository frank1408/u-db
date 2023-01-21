
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.wsinterface.IWS;
import jakarta.transaction.Transactional;
import com.rodriguez.db.repository.IUsuarioRepository;

@Component
@Service
@Transactional
public class WsUsuario implements IWS<Usuario> {

	@Autowired
	IUsuarioRepository repository;
	
	@Override
	public Set<Usuario> obtener(){
		Set<Usuario> hs = new HashSet<Usuario>();
		hs.addAll( repository.findAll() );
		return hs;
	}
	
	@Override
	public Usuario guardar(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Usuario obtener(Long id) {
		return repository.findById(id).get();
	}	
}
