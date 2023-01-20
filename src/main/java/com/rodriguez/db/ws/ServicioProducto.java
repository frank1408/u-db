
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.wsinterface.IServicio;

import jakarta.transaction.Transactional;

import com.rodriguez.db.repository.IProductoRepository;

@Component
@Service
@Transactional
public class ServicioProducto implements IServicio<Producto> {

	@Autowired
	IProductoRepository repository;
	
	@Override
	public List<Producto> obtener(){
		return (List<Producto>) repository.findAll();
	}
	
	@Override
	public Producto guardar(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Producto> obtener(Long id) {
		return repository.findById(id);
	}	
}
