
package com.rodriguez.db.repository;

import java.io.Serializable;
import java.util.List;
import com.rodriguez.db.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	public List<Usuario> findByCorreoAndContrasena( @PathVariable String correo, @PathVariable String contrasena);
	
}
