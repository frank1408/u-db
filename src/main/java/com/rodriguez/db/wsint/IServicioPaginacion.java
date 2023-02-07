
package com.rodriguez.db.wsint;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IServicioPaginacion<T> {
	@GetMapping("/consultar/pagina/{pagina}/{cantidad}")
	public Page<T> consultarPagina( @PathVariable int pagina, @PathVariable int cantidad);
}
