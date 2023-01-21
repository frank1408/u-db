
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.repository.IProductoRepository;
import com.rodriguez.db.wsinterface.IWS;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class WsProducto implements IWS<Producto>{
	
	@Autowired
	IProductoRepository repoProducto;
	
	public Set<Producto> obtener() {
		Set<Producto> hs = new HashSet<Producto>();
		hs.addAll( repoProducto.findAll() );
		return hs;
	}
	public Producto obtener(Long id) {
		return repoProducto.findById(id).get();
	}
	public Producto guardar(Producto producto) {
		return repoProducto.save(producto);
	}
	public void eliminar(Long id) {
		Producto productoDelete = repoProducto.findById(id).get();
		repoProducto.delete( productoDelete );
	}
}
