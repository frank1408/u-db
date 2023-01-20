
package com.rodriguez.db.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends
	//PagingAndSortingRepository<Producto, Serializable>,
	//CrudRepository<Producto, Serializable>,
	JpaRepository<Producto, Serializable> {
}
