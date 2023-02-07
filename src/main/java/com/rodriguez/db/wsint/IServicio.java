
package com.rodriguez.db.wsint;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public interface IServicio<T> {
	
	@GetMapping("/consultar")
	public List<T> consultar();
	
	@GetMapping("/consultar/{id}")
	public T consultarId(@PathVariable Long id);
	
	@PostMapping("/guardar")
	public T guardar(@RequestBody T customEntity );
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarId(@PathVariable Long id);
	
}
