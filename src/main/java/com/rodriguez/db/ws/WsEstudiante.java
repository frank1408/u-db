
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Estudiante;
import com.rodriguez.db.repository.IEstudianteRepository;
import com.rodriguez.db.wsinterface.IWS;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class WsEstudiante implements IWS<Estudiante> {
	@Autowired
	IEstudianteRepository repoEstudiante;
	public Set<Estudiante> obtener() {
		Set<Estudiante> hs = new HashSet<Estudiante>();
		hs.addAll( repoEstudiante.findAll() );
		return hs;
	}
	public Estudiante obtener(Long id) {
		return repoEstudiante.findById(id).get();
	}
	public Estudiante guardar(Estudiante estudiante) {
		return repoEstudiante.save(estudiante);
	}
	public void eliminar(Long id) {
		Estudiante estudianteDelete = repoEstudiante.findById(id).get();
		repoEstudiante.delete( estudianteDelete );
	}
}
