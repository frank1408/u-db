
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Estudiante;
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.repository.IEstudianteRepository;
import com.rodriguez.db.repository.IUniversidadRepository;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class ServicioUniversidadEstudiante {

	@Autowired
	IUniversidadRepository repoUniversidad;
	
	@Autowired
	IEstudianteRepository repoEstudiante;

	public Set<Universidad> obtenerUniversidad() {
		Set<Universidad> hs = new HashSet<Universidad>();
		hs.addAll( repoUniversidad.findAll() );
		return hs;
	}
	public Universidad obtenerUniversidad(Long id) {
		return repoUniversidad.findById(id).get();
	}
	public Universidad guardarUniversidad(Universidad universidad) {
		return repoUniversidad.save(universidad);
	}
	public void eliminarUniversidad(Long id) {
		Universidad universidadDelete = repoUniversidad.findById(id).get();
		repoUniversidad.delete( universidadDelete );
	}
	/*******************************************************/
	public Set<Estudiante> obtenerEstudiante() {
		Set<Estudiante> hs = new HashSet<Estudiante>();
		hs.addAll( repoEstudiante.findAll() );
		return hs;
	}
	public Estudiante obtenerEstudiante(Long id) {
		return repoEstudiante.findById(id).get();
	}
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repoEstudiante.save(estudiante);
	}
	public void eliminarEstudiante(Long id) {
		Estudiante estudianteDelete = repoEstudiante.findById(id).get();
		repoEstudiante.delete( estudianteDelete );
	}
}
