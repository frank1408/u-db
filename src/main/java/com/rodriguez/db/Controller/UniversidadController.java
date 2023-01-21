
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
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.ws.WsUniversidad;

@RestController
@CrossOrigin
@RequestMapping("/universidad")
public class UniversidadController {
	@Autowired
	WsUniversidad service;
	@GetMapping("/obtener")
	public Set<Universidad> obtener() {
		return service.obtener();
	}
	@GetMapping("/obtener/{id}")
	public Universidad obtener( @PathVariable Long id) {
		return service.obtener(id);
	}
	@PostMapping("/guardar")
	public ResponseEntity<Long> guardar( @RequestBody Universidad universidad ) {
		Universidad newUniversidad = service.guardar(universidad);
		return new ResponseEntity<Long>( newUniversidad.getId(), HttpStatus.OK);
	}
	@PostMapping("/guardar2")
	public ResponseEntity<Set<Long>> guardar( @RequestBody Set<Universidad> universidad ) {
		Set<Long> losid = new HashSet<Long>();
		universidad.forEach( universidadd -> {
			Universidad newUniversidad = service.guardar(universidadd);
			losid.add(newUniversidad.getId());
		});
		return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}
} // UniversidadController
