package com.rodriguez.db.wsinterface;

import java.util.List;
import java.util.Optional;

public interface IServicio<T> {
	public List<T> obtener();
	public Optional<T> obtener( Long id);
	public T guardar( T persona );
	public void eliminar( Long id);	
}
