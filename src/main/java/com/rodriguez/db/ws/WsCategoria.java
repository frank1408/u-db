
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import com.rodriguez.db.wsint.IServicio;
import com.rodriguez.db.wsint.IServicioPaginacion;

@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class WsCategoria implements IServicio<Categoria>, IServicioPaginacion<Categoria> {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping("/consultar")
	public List<Categoria> consultar() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Categoria consultarId( @PathVariable Long id) {
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
	public void eliminarId( @PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	@GetMapping("/consultar/pagina/{pagina}/{cantidad}")
	public Page<Categoria> consultarPagina(@PathVariable int pagina,@PathVariable int cantidad) {
		Pageable paginador = PageRequest.of(pagina, cantidad, Sort.by(Direction.ASC,"id") );
		return categoriaRepository.findAll(paginador);
	}
}
