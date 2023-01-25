
package com.rodriguez.db.ws;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.db.entity.Estudiante;
import com.rodriguez.db.repository.EstudianteRepository;
import com.rodriguez.db.wsinterface.Iwebservice;

//@Component
//@Service
//@Transactional
@RestController
@CrossOrigin
@RequestMapping("/estudiante")
public class WsEstudiante implements Iwebservice<Estudiante> {
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@GetMapping("/consultar")
	public List<Estudiante> obtener() {
		return estudianteRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Estudiante obtener(@PathVariable Long id) {
		return estudianteRepository.findById(id).get();
	}
	
	@PostMapping("/guardar")
	public Estudiante guardar(@RequestBody Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		estudianteRepository.deleteById(id);
	}
	
}
