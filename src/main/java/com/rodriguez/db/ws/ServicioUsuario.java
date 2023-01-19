package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.wsinterface.IServicio;
import com.rodriguez.db.repository.UsuarioRepository;

@Service
public class ServicioUsuario implements IServicio<Usuario> {

	@Autowired
	UsuarioRepository dbcontext;
	
	@Override
	public List<Usuario> obtener(){
		return dbcontext.findAll();
	}
	
	@Override
	public Usuario guardar(Usuario usuario) {
		return dbcontext.save(usuario);
	}

	@Override
	public void eliminar(Long id) {
		this.dbcontext.deleteById(id);
	}

	@Override
	public Optional<Usuario> obtener(Long id) {
		return this.dbcontext.findById(id);
	}	
}
