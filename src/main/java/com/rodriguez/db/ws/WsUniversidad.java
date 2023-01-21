
package com.rodriguez.db.ws;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Universidad;
import com.rodriguez.db.repository.IUniversidadRepository;
import com.rodriguez.db.wsinterface.IWS;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class WsUniversidad implements IWS<Universidad> {

	@Autowired
	IUniversidadRepository repoUniversidad;

	public Set<Universidad> obtener() {
		Set<Universidad> hs = new HashSet<Universidad>();
		hs.addAll( repoUniversidad.findAll() );
		return hs;
	}
	public Universidad obtener(Long id) {
		return repoUniversidad.findById(id).get();
	}
	public Universidad guardar(Universidad universidad) {
		return repoUniversidad.save(universidad);
	}
	public void eliminar(Long id) {
		Universidad universidadDelete = repoUniversidad.findById(id).get();
		repoUniversidad.delete( universidadDelete );
	}
}
