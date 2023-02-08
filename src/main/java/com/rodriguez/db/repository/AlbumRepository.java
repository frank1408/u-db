
package com.rodriguez.db.repository;

import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Album;

@Repository("albumRepository")
public interface AlbumRepository extends JpaRepository<Album, Serializable> {
	
	@Query(
			nativeQuery=true,
			value="select * from Album order by Album.id asc",
			countQuery="select count(Album.id) from Album"
		)
		Page<Album> buscarPorPagina(Pageable pageable);
	
}
