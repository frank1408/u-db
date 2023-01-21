
package com.rodriguez.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
