/*
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Estudiante;
import com.rodriguez.db.wsinterface.IServicio;
import jakarta.transaction.Transactional;
import com.rodriguez.db.repository.IEstudianteRepository;

@Component
@Service
@Transactional
public class ServicioEstudiante implements IServicio<Estudiante> {

	@Autowired
	IEstudianteRepository repository;
	
	@Override
	public List<Estudiante> obtener(){
		return (List<Estudiante>) repository.findAll();
	}
	@Override
	public Estudiante guardar(Estudiante estudiante) {
		return repository.save(estudiante);
	}
	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}
	@Override
	public Optional<Estudiante> obtener(Long id) {
		return repository.findById(id);
	}
}
*/