
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
import com.rodriguez.db.entity.Categoria;
import com.rodriguez.db.repository.CategoriaRepository;
import com.rodriguez.db.wsinterface.Iwebservice;

//@Component      ?
//@Service
//@Transactional
@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class WsCategoria implements Iwebservice<Categoria> {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping("/consultar")
	public List<Categoria> obtener() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Categoria obtener( @PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}
		return null;
	}
	
	@PostMapping("/guardar")
	public Categoria guardar( @RequestBody Categoria categoria ) {
		return categoriaRepository.save(categoria);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar( @PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
	
}
