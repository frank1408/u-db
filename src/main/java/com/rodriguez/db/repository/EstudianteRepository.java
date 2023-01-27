
package com.rodriguez.db.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.db.entity.Estudiante;

@Repository("estudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Serializable> {
	public List<Estudiante> findByNombreContaining(String nombre);
	public List<Estudiante> findByApellidoContaining(String apellido);
	public List<Estudiante> findByCorreoContaining(String correo);
	public List<Estudiante> findByCorreoNotContaining(String correo);
	public List<Estudiante> findByEstatura(Double estatura);
	public List<Estudiante> findByEstaturaLessThanEqual(Double estatura);
	//public List<Estudiante> findByFechaDeNacimiento(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaDeNacimiento);
	public List<Estudiante> findByGrupoSanguineo(String grupoSanguineo);
	public List<Estudiante> findByPagoMensual(Double pagoMensual);
}
