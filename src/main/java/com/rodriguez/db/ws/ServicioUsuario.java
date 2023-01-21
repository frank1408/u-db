package com.rodriguez.db.ws;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.wsinterface.IServicio;
import jakarta.transaction.Transactional;
import com.rodriguez.db.repository.IUsuarioRepository;

@Component
@Service
@Transactional
public class ServicioUsuario implements IServicio<Usuario> {

	@Autowired
	IUsuarioRepository repository;
	
	@Override
	public List<Usuario> obtener(){
		return repository.findAll();
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
