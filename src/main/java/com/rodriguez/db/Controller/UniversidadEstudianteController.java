
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
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.ws.ServicioUniversidadEstudiante;

@RestController
@CrossOrigin
@RequestMapping("/ws")
public class UniversidadEstudianteController {

	@Autowired
	ServicioUniversidadEstudiante service;
	
	@GetMapping("/estudiante/obtener")
	public Set<Estudiante> obtenerEstudiante() {
		return new HashSet<>(service.obtenerEstudiante());
	}
	@GetMapping("/estudiante/obtener/{id}")
	public Estudiante obtenerEstudiante( @PathVariable Long id) {
		return service.obtenerEstudiante(id);
	}
	@PostMapping("/estudiante/guardar")
	public ResponseEntity<Long> guardarEstudiante( @RequestBody Estudiante estudiante ) {
		Estudiante newEstudiante = service.guardarEstudiante(estudiante);
		return new ResponseEntity<Long>( newEstudiante.getId(), HttpStatus.OK);
	}
	@PostMapping("/estudiante/guardar2")
	public ResponseEntity<Set<Long>> guardarEstudiante2( @RequestBody Set<Estudiante> estudiante ) {
		Set<Long> losid = new HashSet<Long>();

		estudiante.forEach( estudiantee -> {
			Estudiante newEstudiante = service.guardarEstudiante(estudiantee);
			losid.add(newEstudiante.getId());
		});
		return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
	}
	@DeleteMapping("/estudiante/eliminar/{id}")
	public void eliminarEstudiante(@PathVariable Long id) {
		service.eliminarEstudiante(id);
	}
	/********/
	@GetMapping("/universidad/obtener")
	public Set<Universidad> obtenerUniversidad() {
		return service.obtenerUniversidad();
	}
	@GetMapping("/universidad/obtener/{id}")
	public Universidad obtenerUniversidad( @PathVariable Long id) {
		return service.obtenerUniversidad(id);
	}
	@PostMapping("/universidad/guardar")
	public ResponseEntity<Long> guardarUniversidad( @RequestBody Universidad universidad ) {
		Universidad newUniversidad = service.guardarUniversidad(universidad);
	return new ResponseEntity<Long>( newUniversidad.getId(), HttpStatus.OK);
	}

	@PostMapping("/universidad/guardar2")
	public ResponseEntity<Set<Long>> guardarUniversidad2( @RequestBody Set<Universidad> universidad ) {
		Set<Long> losid = new HashSet<Long>();
		universidad.forEach( universidadd -> {
			Universidad newUniversidad = service.guardarUniversidad(universidadd);
			losid.add(newUniversidad.getId());
		});
		return new ResponseEntity<Set<Long>>( losid, HttpStatus.OK);
	}

	@DeleteMapping("/universidad/eliminar/{id}")
	public void eliminarUniversidad(@PathVariable Long id) {
		service.eliminarUniversidad(id);
	}
} // UniversidadEstudianteController
