
package com.rodriguez.db.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Estudiante;

@Repository("estudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Serializable> {
	
	@Query(
		nativeQuery=true,
		value="select * from Estudiante order by estudiante.id asc",
		countQuery="select count(Estudiante.id) from Estudiante"
	)
	Page<Estudiante> buscarPorPagina(Pageable pageable);
	
	public List<Estudiante> findByNombreContaining(String nombre);
	public List<Estudiante> findByApellidoContaining(String apellido);
	public List<Estudiante> findByCorreoContaining(String correo);
	public List<Estudiante> findByCorreoNotContaining(String correo);
	public List<Estudiante> findByEstatura(Double estatura);
	public List<Estudiante> findByEstaturaLessThanEqual(Double estatura);
	public List<Estudiante> findByGrupoSanguineo(String grupoSanguineo);
	public List<Estudiante> findByPagoMensual(Double pagoMensual);
	public List<Estudiante> findByPagoMensualGreaterThan(Double pagoMensual);
}
