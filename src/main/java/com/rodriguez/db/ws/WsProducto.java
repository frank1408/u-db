
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
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.repository.ProductoRepository;
import com.rodriguez.db.wsint.IServicio;
import com.rodriguez.db.wsint.IServicioPaginacion;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class WsProducto implements IServicio<Producto>, IServicioPaginacion<Producto>{
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/consultar")
	public List<Producto> consultar() {
		return productoRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Producto consultarId(@PathVariable Long id) {
		Optional<Producto> producto =  productoRepository.findById(id);
		if( producto.isPresent() ) {
			return producto.get();
		}
		return null;
	}
	
	@PostMapping("/guardar")
	public Producto guardar(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarId(@PathVariable Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	@GetMapping("/consultar/pagina/{pagina}/{cantidad}")
	public Page<Producto> consultarPagina(int pagina, int cantidad) {
		Pageable paginador = PageRequest.of(pagina, cantidad, Sort.by(Direction.ASC,"id") );
		return productoRepository.findAll(paginador);
	}
}
