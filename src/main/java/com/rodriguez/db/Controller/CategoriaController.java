
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
import com.rodriguez.db.ws.ServicioCategoriaProducto;

@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaController {
	
@Autowired
ServicioCategoriaProducto service;
	
@GetMapping("/obtener")
public Set<Categoria> obtenerCategoria() {
	return service.obtenerCategoria();
}
@GetMapping("/obtener/{id}")
public Categoria obtenerCategoria( @PathVariable Long id) {
	return service.obtenerCategoria(id);
}
@PostMapping("/guardar")
public ResponseEntity<Long> guardarCategoria( @RequestBody Categoria categoria ) {
	Categoria newCategoria = service.guardarCategoria(categoria);
	return new ResponseEntity<Long>( newCategoria.getId(), HttpStatus.OK);
}
@PostMapping("/guardar2")
public ResponseEntity<Set<Long>> guardarCategoria2( @RequestBody Set<Categoria> categoria ) {
	Set<Long> losid = new HashSet<Long>();
	categoria.forEach( categoriad -> {
		Categoria newCategoria = service.guardarCategoria(categoriad);
		losid.add(newCategoria.getId());
	});
	return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
}
@DeleteMapping("/eliminar/{id}")
public void eliminarCategoria(@PathVariable Long id) {
	service.eliminarCategoria(id);
}
} // CategoriaController
