
package com.rodriguez.db.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import com.rodriguez.db.ws.ServicioUsuario;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

@Autowired
ServicioUsuario service;

@GetMapping("/obtener")
public List<Usuario> obtener() {
return service.obtener();
}

@GetMapping("/obtener/{id}")
public Optional<Usuario> obtener( @PathVariable Long id) {
	
// @PathVariable Long id			/obtener/1
// @RequestParam Long id			?name=juan
// @RequestBody Usuario persona		{"nombre":"juan","correo":"juan@gmail.com"}

return service.obtener(id);
}

@PostMapping("/guardar")
public ResponseEntity<Long> guardar( @RequestBody Usuario usuario ) {
Usuario newUser = service.guardar(usuario);
return new ResponseEntity<Long>( newUser.getId(), HttpStatus.OK);
}

@PostMapping("/guardar2")
public ResponseEntity<List<Long>> guardar2( @RequestBody List<Usuario> usuario ) {
List<Long> losid = new ArrayList<Long>();

usuario.forEach( useer -> {
	Usuario newUser = service.guardar(useer);
	losid.add(newUser.getId());
});

return new ResponseEntity<List<Long>>( losid, HttpStatus.OK);
}


@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id) {
	service.eliminar(id);
}


} // UsuarioController
