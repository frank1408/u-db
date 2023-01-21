
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Categoria;
import com.rodriguez.db.repository.ICategoriaRepository;
import com.rodriguez.db.wsinterface.IWS;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class WsCategoria implements IWS<Categoria> {

	@Autowired
	ICategoriaRepository repoCategoria;

	public Set<Categoria> obtener() {
		Set<Categoria> hs = new HashSet<Categoria>();
		hs.addAll( repoCategoria.findAll() );
		return hs;
	}
	public Categoria obtener(Long id) {
		return repoCategoria.findById(id).get();
	}
	public Categoria guardar(Categoria categoria) {
		return repoCategoria.save(categoria);
	}
	public void eliminar(Long id) {
		Categoria categoriaDelete = repoCategoria.findById(id).get();
		repoCategoria.delete( categoriaDelete );
	}
}
