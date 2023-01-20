
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.wsinterface.IServicio;
import jakarta.transaction.Transactional;
import com.rodriguez.db.repository.IUniversidadRepository;

@Component
@Service
@Transactional
public class ServicioUniversidad implements IServicio<Universidad> {

	@Autowired
	IUniversidadRepository repository;
	
	@Override
	public List<Universidad> obtener(){
		return (List<Universidad>) repository.findAll();
	}
	
	@Override
	public Universidad guardar(Universidad categoria) {
		return repository.save(categoria);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Universidad> obtener(Long id) {
		return repository.findById(id);
	}	
}
