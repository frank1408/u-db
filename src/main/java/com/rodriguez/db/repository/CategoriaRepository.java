
package com.rodriguez.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rodriguez.db.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
