
package com.rodriguez.db.repository;

import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Foto;

@Repository("fotoRepository")
public interface FotoRepository extends JpaRepository<Foto,Serializable> {
	
	@Query(
			nativeQuery=true,
			value="select * from Foto order by Foto.id asc",
			countQuery="select count(Foto.id) from Foto"
		)
		Page<Foto> buscarPorPagina(Pageable pageable);
	
}
