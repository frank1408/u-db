
package com.rodriguez.db.wsinterface;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/servicio")
public interface Iwebservice<T> {
	
	@GetMapping("/consultar")
	public List<T> obtener();
	
	@GetMapping("/consultar/{id}")
	public T obtener(@PathVariable Long id);
	
	@PostMapping("/guardar")
	public T guardar(@RequestBody T customEntity );
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id);
	
}
