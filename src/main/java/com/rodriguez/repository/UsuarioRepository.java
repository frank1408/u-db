package com.rodriguez.repository;

import java.io.Serializable;
import com.rodriguez.db.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
}
