
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.wsinterface.IServicio;
import com.rodriguez.db.repository.ProductoRepository;

@Service
public class ServicioProducto implements IServicio<Producto> {

	@Autowired
	ProductoRepository dbcontext;
	
	@Override
	public List<Producto> obtener(){
		return dbcontext.findAll();
	}
	
	@Override
	public Producto guardar(Producto producto) {
		return dbcontext.save(producto);
	}

	@Override
	public void eliminar(Long id) {
		this.dbcontext.deleteById(id);
	}

	@Override
	public Optional<Producto> obtener(Long id) {
		return this.dbcontext.findById(id);
	}	
}
