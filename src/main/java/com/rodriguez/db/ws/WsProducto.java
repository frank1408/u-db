
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
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.repository.ProductoRepository;
import com.rodriguez.db.wsinterface.Iwebservice;

//@Component
//@Service
//@Transactional
@RestController
@CrossOrigin
@RequestMapping("/producto")
public class WsProducto implements Iwebservice<Producto>{
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/consultar")
	public List<Producto> obtener() {
		return productoRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Producto obtener(@PathVariable Long id) {
		return productoRepository.findById(id).get();
	}
	
	@PostMapping("/guardar")
	public Producto guardar(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		productoRepository.deleteById(id);
	}
	
	
}
