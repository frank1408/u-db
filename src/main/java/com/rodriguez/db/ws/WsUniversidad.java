
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
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.repository.UniversidadRepository;
import com.rodriguez.db.wsinterface.Iwebservice;

//@Component
//@Service
//@Transactional
@RestController
@CrossOrigin
@RequestMapping("/universidad")
public class WsUniversidad implements Iwebservice<Universidad> {

	@Autowired
	UniversidadRepository universidadRepository;

	@GetMapping("/consultar")
	public List<Universidad> obtener() {
		return universidadRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Universidad obtener(@PathVariable Long id) {
		return universidadRepository.findById(id).get();
	}
	
	@PostMapping("/guardar")
	public Universidad guardar(@RequestBody Universidad universidad) {
		return universidadRepository.save(universidad);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		universidadRepository.deleteById(id);
	}
	
}
