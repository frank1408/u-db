
package com.rodriguez.db.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.ws.ServicioProducto;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoController {

@Autowired
ServicioProducto service;

@GetMapping("/obtener")
public List<Producto> obtener() {
return service.obtener();
}

@GetMapping("/obtener/{id}")
public Optional<Producto> obtener( @PathVariable Long id) {
	
// @PathVariable Long id			/obtener/1
// @RequestParam Long id			?name=juan
// @RequestBody Usuario persona		{"nombre":"juan","correo":"juan@gmail.com"}

return service.obtener(id);
}

@PostMapping("/guardar")
public ResponseEntity<Long> guardar( @RequestBody Producto producto ) {
Producto newProducto = service.guardar(producto);
return new ResponseEntity<Long>( newProducto.getId(), HttpStatus.OK);
}

@PostMapping("/guardar2")
public ResponseEntity<List<Long>> guardar2( @RequestBody List<Producto> producto ) {
List<Long> losid = new ArrayList<Long>();

producto.forEach( productoo -> {
	Producto newProducto = service.guardar(productoo);
	losid.add(newProducto.getId());
});

return new ResponseEntity<List<Long>>( losid, HttpStatus.OK);
}

@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id) {
	service.eliminar(id);
}


} // UsuarioController
