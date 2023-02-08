
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

import com.rodriguez.db.entity.Album;
import com.rodriguez.db.entity.Foto;
import com.rodriguez.db.repository.FotoRepository;
import com.rodriguez.db.wsint.IServicio;

@RestController
@CrossOrigin
@RequestMapping("/foto")
public class WsFoto implements IServicio<Foto> {
	
	@Autowired
	FotoRepository fotoRepository;
	
	@Override
	@GetMapping("/consultar")
	public List<Foto> consultar() {
		return fotoRepository.findAll();
	}
	
	@Override
	@GetMapping("/consultar/{id}")
	public Foto consultarId( @PathVariable Long id) {
		Optional<Foto> foto = fotoRepository.findById(id);
		if( foto.isPresent() ) {
			return foto.get();
		}
		return null;
	}
	
	@Override
	@PostMapping("/guardar")
	public Foto guardar( @RequestBody Foto foto) {
		return fotoRepository.save(foto);
	}
	
	@Override
	@DeleteMapping("/eliminar/{id}")
	public void eliminarId( @PathVariable Long id) {
		fotoRepository.deleteById(id);
	}
	
	
	
	
	
	@GetMapping("/consultar/pagina/{pagina}/{cantidad}")
	public Page<Foto> consultarPagina(@PathVariable int pagina,@PathVariable int cantidad) {
		Pageable paginador = PageRequest.of(pagina, cantidad, Sort.by(Direction.ASC,"id") );
		return fotoRepository.findAll(paginador);
	}
	
}
