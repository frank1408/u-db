
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Producto;
import com.rodriguez.db.entity.Categoria;
import com.rodriguez.db.repository.IProductoRepository;
import com.rodriguez.db.repository.ICategoriaRepository;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class ServicioCategoriaProducto {

	@Autowired
	ICategoriaRepository repoCategoria;
	
	@Autowired
	IProductoRepository repoProducto;

	public Set<Categoria> obtenerCategoria() {
		Set<Categoria> hs = new HashSet<Categoria>();
		hs.addAll( repoCategoria.findAll() );
		return hs;
	}
	public Categoria obtenerCategoria(Long id) {
		return repoCategoria.findById(id).get();
	}
	public Categoria guardarCategoria(Categoria categoria) {
		return repoCategoria.save(categoria);
	}
	public void eliminarCategoria(Long id) {
		Categoria categoriaDelete = repoCategoria.findById(id).get();
		repoCategoria.delete( categoriaDelete );
	}
	/*******************************************************/
	public Set<Producto> obtenerProducto() {
		Set<Producto> hs = new HashSet<Producto>();
		hs.addAll( repoProducto.findAll() );
		return hs;
	}
	public Producto obtenerProducto(Long id) {
		return repoProducto.findById(id).get();
	}
	public Producto guardarProducto(Producto producto) {
		return repoProducto.save(producto);
	}
	public void eliminarProducto(Long id) {
		Producto productoDelete = repoProducto.findById(id).get();
		repoProducto.delete( productoDelete );
	}
}
