package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.ws.ServicioImplementacion;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class UsuarioController {

	@Autowired
	private ServicioImplementacion servicioImplementacion;
	
	@GetMapping("/obtener")
	public List<Usuario> obtener() {
		return this.servicioImplementacion.obtener();
	}
	
	@PostMapping("/guardar")
	public void guardar( @RequestBody Usuario persona ) {
		this.servicioImplementacion.guardar(persona);
	}
	
	
} // UsuarioController
