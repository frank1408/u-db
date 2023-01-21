
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
import com.rodriguez.db.entity.Estudiante;
import com.rodriguez.db.ws.WsEstudiante;

@RestController
@CrossOrigin
@RequestMapping("/estudiante")
public class EstudianteController {
	@Autowired
	WsEstudiante service;
	@GetMapping("/obtener")
	public Set<Estudiante> obtener() {
		return new HashSet<>(service.obtener());
	}
	@GetMapping("/obtener/{id}")
	public Estudiante obtener( @PathVariable Long id) {
		return service.obtener(id);
	}
	@PostMapping("/guardar")
	public ResponseEntity<Long> guardar( @RequestBody Estudiante estudiante ) {
		Estudiante newEstudiante = service.guardar(estudiante);
		return new ResponseEntity<Long>( newEstudiante.getId(), HttpStatus.OK);
	}
	@PostMapping("/guardar2")
	public ResponseEntity<Set<Long>> guardar( @RequestBody Set<Estudiante> estudiante ) {
		Set<Long> losid = new HashSet<Long>();
		estudiante.forEach( estudiantee -> {
			Estudiante newEstudiante = service.guardar(estudiantee);
			losid.add(newEstudiante.getId());
		});
		return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}
} // EstudianteController
