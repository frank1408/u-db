package com.rodriguez.db.wsinterface;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rodriguez.db.entity.Usuario;

//@RestController
//@CrossOrigin
//@RequestMapping("/service")
@Service
public interface IServicio {
	
	//@Autowired
	//UsuarioRepository dbcontext;
	
	@GetMapping("/obtener")
	public List<Usuario> obtener();
	
	@PostMapping("/guardar")
	public void guardar( @RequestBody Usuario persona );
	
	
}
