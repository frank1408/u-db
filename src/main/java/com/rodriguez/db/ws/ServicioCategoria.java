
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Categoria;
import com.rodriguez.db.wsinterface.IServicio;
import com.rodriguez.db.repository.CategoriaRepository;

@Service
public class ServicioCategoria implements IServicio<Categoria> {

	@Autowired
	CategoriaRepository dbcontext;
	
	@Override
	public List<Categoria> obtener(){
		return dbcontext.findAll();
	}
	
	@Override
	public Categoria guardar(Categoria categoria) {
		return dbcontext.save(categoria);
	}

	@Override
	public void eliminar(Long id) {
		this.dbcontext.deleteById(id);
	}

	@Override
	public Optional<Categoria> obtener(Long id) {
		return this.dbcontext.findById(id);
	}	
}
