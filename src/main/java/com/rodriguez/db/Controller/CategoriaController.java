
package com.rodriguez.db.Controller;

import java.util.HashSet;
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
import com.rodriguez.db.entity.Categoria;
import com.rodriguez.db.ws.WsCategoria;

@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaController {
@Autowired
WsCategoria service;
@GetMapping("/obtener")
public Set<Categoria> obtener() {
	return service.obtener();
}
@GetMapping("/obtener/{id}")
public Categoria obtener( @PathVariable Long id) {
	return service.obtener(id);
}
@PostMapping("/guardar")
public ResponseEntity<Long> guardar( @RequestBody Categoria categoria ) {
	Categoria newCategoria = service.guardar(categoria);
	return new ResponseEntity<Long>( newCategoria.getId(), HttpStatus.OK);
}
@PostMapping("/guardar2")
public ResponseEntity<Set<Long>> guardar( @RequestBody Set<Categoria> categoria ) {
	Set<Long> losid = new HashSet<Long>();
	categoria.forEach( categoriad -> {
		Categoria newCategoria = service.guardar(categoriad);
		losid.add(newCategoria.getId());
	});
	return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id) {
	service.eliminar(id);
}
} // CategoriaController
