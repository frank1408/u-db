
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.repository.UsuarioRepository;
import com.rodriguez.db.wsint.IServicioPaginacion;
import com.rodriguez.db.wsint.IServicio;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class WsUsuario implements IServicio<Usuario>, IServicioPaginacion<Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/consultar")
	public List<Usuario> consultar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Usuario consultarId(@PathVariable Long id) {
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
	public void eliminarId(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@GetMapping("/consultar/pagina/{pagina}/{cantidad}")
	public Page<Usuario> consultarPagina( @PathVariable int pagina, @PathVariable int cantidad) {
		Pageable paginador = PageRequest.of( pagina, cantidad, Sort.by(Direction.ASC,"id") );
		return usuarioRepository.findAll(paginador);
	}
	
}
