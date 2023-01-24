
package com.rodriguez.db.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Categoria;

@Repository("categoriaRepository")
public interface ICategoriaRepository extends JpaRepository<Categoria, Serializable>{
}
