
package com.rodriguez.db.Controller;

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
ServicioProducto servicioImplementacion;

@GetMapping("/obtener")
public List<Producto> obtener() {
return this.servicioImplementacion.obtener();
}

@GetMapping("/obtener/{id}")
public Optional<Producto> obtener( @PathVariable Long id) {
	
// @PathVariable Long id			/obtener/1
// @RequestParam Long id			?name=juan
// @RequestBody Usuario persona		{"nombre":"juan","correo":"juan@gmail.com"}

return this.servicioImplementacion.obtener(id);
}

@PostMapping("/guardar")
public ResponseEntity<Long> guardar( @RequestBody Producto producto ) {
Producto newProducto = this.servicioImplementacion.guardar(producto);
return new ResponseEntity<Long>( newProducto.getId(), HttpStatus.OK);
}

@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id) {
this.servicioImplementacion.eliminar(id);
}


} // UsuarioController
