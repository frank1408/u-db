
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
//import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Categoria;
import com.rodriguez.db.wsinterface.IServicio;

import jakarta.transaction.Transactional;

import com.rodriguez.db.repository.ICategoriaRepository;

@Component
@Service
@Transactional
public class ServicioCategoria implements IServicio<Categoria> {

	@Autowired
	ICategoriaRepository repository;
	
	@Override
	public List<Categoria> obtener(){
		return (List<Categoria>) repository.findAll();
	}
	
	@Override
	public Categoria guardar(Categoria categoria) {
		return repository.save(categoria);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Categoria> obtener(Long id) {
		return repository.findById(id);
	}	
}
