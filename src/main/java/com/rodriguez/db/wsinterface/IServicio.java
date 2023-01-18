package com.rodriguez.db.wsinterface;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.db.entity.Usuario;

//@RestController
//@CrossOrigin
//@RequestMapping("/service")
public interface IServicio {
	
	@GetMapping("/obtener")
	public List<Usuario> obtener();
	
	@PostMapping("/guardar")
	public void guardar( @RequestBody Usuario persona );
	
	
}
