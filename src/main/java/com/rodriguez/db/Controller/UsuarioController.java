
package com.rodriguez.db.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.ws.WsUsuario;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
@Autowired
WsUsuario service;
@GetMapping("/obtener")
public Set<Usuario> obtener() {
return service.obtener();
}
@GetMapping("/obtener/{id}")
public Usuario obtener( @PathVariable Long id) {
	return service.obtener(id);
}
@PostMapping("/guardar")
public ResponseEntity<Long> guardar( @RequestBody Usuario usuario ) {
	Usuario newUser = service.guardar(usuario);
	return new ResponseEntity<Long>( newUser.getId(), HttpStatus.OK);
}
@PostMapping("/guardar2")
public ResponseEntity<Set<Long>> guardar2( @RequestBody List<Usuario> usuario ) {
	Set<Long> losid = new HashSet<Long>();
	usuario.forEach( useer -> {
		Usuario newUser = service.guardar(useer);
		losid.add(newUser.getId());
	});
	return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id) {
	service.eliminar(id);
}
} // UsuarioController
