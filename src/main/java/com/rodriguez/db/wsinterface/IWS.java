
package com.rodriguez.db.wsinterface;

import java.util.Set;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public interface IWS<T> {
	public Set<T> obtener();
	public T obtener( Long id);
	public T guardar( T persona );
	public void eliminar( Long id);	
}