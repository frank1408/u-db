package com.rodriguez.db.ws;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Usuario;
import com.rodriguez.db.wsinterface.IServicio;
import com.rodriguez.db.repository.UsuarioRepository;

//@Component
@Service
public class ServicioImplementacion implements IServicio {

	@Autowired
	UsuarioRepository dbcontext;
	
	@Override
	public List<Usuario> obtener(){
		return dbcontext.findAll();
	}
	
	@Override
	public void guardar(Usuario persona) {
		dbcontext.save(persona);
	}
}
