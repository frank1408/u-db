
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
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
import com.rodriguez.db.wsint.IServicio;

@RestController
@CrossOrigin
@RequestMapping("/universidad")
public class WsUniversidad implements IServicio<Universidad> {

	@Autowired
	UniversidadRepository universidadRepository;

	@GetMapping("/consultar")
	public List<Universidad> consultar() {
		return universidadRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Universidad consultarId(@PathVariable Long id) {
		Optional<Universidad> universidad = universidadRepository.findById(id);
		if(universidad.isPresent()) {
			return universidad.get();
		}
		return null;
	}
	
	@PostMapping("/guardar")
	public Universidad guardar(@RequestBody Universidad universidad) {
		return universidadRepository.save(universidad);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarId(@PathVariable Long id) {
		universidadRepository.deleteById(id);
	}
	
}
