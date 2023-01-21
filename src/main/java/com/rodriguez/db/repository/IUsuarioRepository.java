
package com.rodriguez.db.repository;

import com.rodriguez.db.entity.Usuario;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
