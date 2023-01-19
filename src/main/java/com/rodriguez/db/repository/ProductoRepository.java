
package com.rodriguez.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rodriguez.db.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
