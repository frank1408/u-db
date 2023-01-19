package com.rodriguez.db.wsinterface;

import java.util.List;
import java.util.Optional;
import com.rodriguez.db.entity.Usuario;

public interface IServicio {
	public List<Usuario> obtener();
	public Optional<Usuario> obtener( Long id);
	public Usuario guardar( Usuario persona );
	public void eliminar( Long id);	
}
