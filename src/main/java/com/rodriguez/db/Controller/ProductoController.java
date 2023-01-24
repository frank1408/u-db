
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
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.ws.WsProducto;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	WsProducto service;
	@GetMapping("/obtener")
	public Set<Producto> obtener() {
		return new HashSet<>(service.obtener());
	}
	@GetMapping("/obtener/{id}")
	public Producto obtener( @PathVariable Long id) {
		return service.obtener(id);
	}
	@PostMapping("/guardar")
	public ResponseEntity<Long> guardar( @RequestBody Producto producto ) {
		Producto newProducto = service.guardar(producto);
		return new ResponseEntity<Long>( newProducto.getId(), HttpStatus.OK);
	}
	@PostMapping("/guardar2")
	public ResponseEntity<Set<Long>> guardar( @RequestBody Set<Producto> producto ) {
		Set<Long> losid = new HashSet<Long>();
		producto.forEach( productoo -> {
			Producto newProducto = service.guardar(productoo);
			losid.add(newProducto.getId());
		});
		return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}
} // ProductoController