
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
import com.rodriguez.db.repository.AlbumRepository;
import com.rodriguez.db.wsint.IServicio;

@RestController
@CrossOrigin
@RequestMapping("/album")
public class WsAlbum implements IServicio<Album> {
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Override
	@GetMapping("/consultar")
	public List<Album> consultar() {
		return albumRepository.findAll();
	}

	@Override
	@GetMapping("/consultar/{id}")
	public Album consultarId( @PathVariable Long id) {
		
		Optional<Album> album = albumRepository.findById(id);
		if( album.isPresent() ) {
			return album.get();
		}
		return null;
	}

	@Override
	@PostMapping("/guardar")
	public Album guardar( @RequestBody Album album) {
		return albumRepository.save(album);
	}

	@Override
	@DeleteMapping("/eliminar/{id}")
	public void eliminarId( @PathVariable Long id) {
		albumRepository.deleteById(id);
	}
	
	
	
	@GetMapping("/consultar/pagina/{pagina}/{cantidad}")
	public Page<Album> consultarPagina(@PathVariable int pagina,@PathVariable int cantidad) {
		Pageable paginador = PageRequest.of(pagina, cantidad, Sort.by(Direction.ASC,"id") );
		return albumRepository.findAll(paginador);
	}
}
