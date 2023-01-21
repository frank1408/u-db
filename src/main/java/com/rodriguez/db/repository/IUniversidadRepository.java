
package com.rodriguez.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Universidad;

@Repository("universidadRepository")
public interface IUniversidadRepository extends JpaRepository<Universidad, Long> {
}

