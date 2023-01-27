
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.wsinterface.Iwebservice;
import com.rodriguez.db.repository.UsuarioRepository;

//@Component
//@Service
//@Transactional
@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class WsUsuario implements Iwebservice<Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/consultar")
	public List<Usuario> obtener(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Usuario obtener(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}
	
	@PostMapping("/guardar")
	public Usuario guardar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}

}
