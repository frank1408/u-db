package com.rodriguez.db.wsinterface;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
//import java.util.Set;

@RestController
@CrossOrigin
public interface IServicio<T> {
	public List<T> obtener();
	public Optional<T> obtener( Long id);
	public T guardar( T persona );
	public void eliminar( Long id);	
}
