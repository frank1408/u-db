/*
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
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.ws.ServicioUniversidad;

@RestController
@CrossOrigin
@RequestMapping("/universidad")
public class UniversidadController {

@Autowired
ServicioUniversidad service;

@GetMapping("/obtener")
public ResponseEntity<List<Universidad>> obtener() {
return new ResponseEntity<List<Universidad>>(
		service.obtener(),
		HttpStatus.OK
	);
}

@GetMapping("/obtener/{id}")
public ResponseEntity<Optional<Universidad>> obtener( @PathVariable Long id) {
	
// @PathVariable Long id			/obtener/1
// @RequestParam Long id			?name=juan
// @RequestBody Usuario persona		{"nombre":"juan","correo":"juan@gmail.com"}

return new ResponseEntity<Optional<Universidad>>(
		service.obtener(id),
		HttpStatus.OK
	);
}

@PostMapping("/guardar")
public ResponseEntity<Long> guardar( @RequestBody Universidad categoria ) {
Universidad newUniversidad = service.guardar(categoria);
return new ResponseEntity<Long>( newUniversidad.getId(), HttpStatus.OK);
}


@PostMapping("/guardar2")
public ResponseEntity<List<Long>> guardar2( @RequestBody List<Universidad> categoria ) {
List<Long> losid = new ArrayList<Long>();

categoria.forEach( categoriaa -> {
	Universidad newUniversidad = service.guardar(categoriaa);
	losid.add(newUniversidad.getId());
});

return new ResponseEntity<List<Long>>( losid, HttpStatus.OK);
}



@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id) {
	service.eliminar(id);
}


} // UniversidadController
*/