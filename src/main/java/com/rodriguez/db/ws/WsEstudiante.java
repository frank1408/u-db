
package com.rodriguez.db.ws;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.db.entity.Estudiante;
import com.rodriguez.db.repository.EstudianteRepository;
import com.rodriguez.db.service.EstudianteServicio;
import com.rodriguez.db.wsinterface.Iwebservice;

//@Component
//@Service
//@Transactional
@RestController
@CrossOrigin
@RequestMapping("/estudiante")
public class WsEstudiante implements Iwebservice<Estudiante> {
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	EstudianteServicio estudianteServicio;
	
	@GetMapping("/consultar")
	public List<Estudiante> obtener() {
		return estudianteRepository.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Estudiante obtener(@PathVariable Long id) {
		Optional<Estudiante> estudiante = estudianteRepository.findById(id);
		if(estudiante.isPresent()) {
			return estudiante.get();
		}
		return null;
	}
	
	@PostMapping("/guardar")
	public Estudiante guardar(@RequestBody Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		estudianteRepository.deleteById(id);
	}
	
	
	
	
	/*
	 * servicios de busqueda/filtros
	 * con consultas DSL
	 * y con querys personalizadas
	 */
	@GetMapping("/consultar/nombre/{nombre}")
	public List<Estudiante> obtenerPorNombre(@PathVariable("nombre") String nombre) {
		return estudianteRepository.findByNombreContaining(nombre);
	}
	@GetMapping("/consultar/apellido/{apellido}")
	public List<Estudiante> obtenerPorApellido(@PathVariable("apellido") String apellido) {
		return estudianteRepository.findByApellidoContaining(apellido);
	}
	@GetMapping("/consultar/correo/{correo}")
	public List<Estudiante> obtenerPorCorreo(@PathVariable("correo") String correo) {
		return estudianteRepository.findByCorreoContaining(correo);
	}
	@GetMapping("/consultar/correo/nocontenga/{correo}")
	public List<Estudiante> obtenerPorCorreoNoContenga(@PathVariable("correo") String correo) {
		return estudianteRepository.findByCorreoNotContaining(correo);
	}
	@GetMapping("/consultar/estatura/{estatura}")
	public List<Estudiante> obtenerPorEstatura(@PathVariable("estatura") Double estatura) {
		return estudianteRepository.findByEstatura(estatura);
	}
	@GetMapping("/consultar/estatura/menoroigual/{estatura}")
	public List<Estudiante> obtenerPorEstaturaMenorOIgual(@PathVariable("estatura") Double estatura) {
		return estudianteRepository.findByEstaturaLessThanEqual(estatura);
	}
	/*
	@GetMapping("/consultar/fechadenacimiento/{fechaDeNacimiento}")
	public List<Map<String, Object>> obtenerPorFechaDeNacimiento(
			@PathVariable("fechaDeNacimiento")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			LocalDateTime fechaDeNacimiento) {
		return estudianteRepository.findByFechaDeNacimiento(fechaDeNacimiento);
		return estudianteServicio.buscarPorFechaDeNacimiento(fechaDeNacimiento);
	}
	*/
	@GetMapping("/consultar/gruposanguineo/{grupoSanguineo}")
	public List<Estudiante> obtenerPorGrupoSanguineo(@PathVariable("grupoSanguineo") String grupoSanguineo) {
		return estudianteRepository.findByGrupoSanguineo(grupoSanguineo);
	}
	@GetMapping("/consultar/pagomensual/{pagoMensual}")
	public List<Estudiante> obtenerPorPagoMensual(@PathVariable("pagoMensual") Double pagoMensual) {
		return estudianteRepository.findByPagoMensual(pagoMensual);
	}
	@GetMapping("/consultar/pagomensual/mayorque/{pagoMensual}")
	public List<Estudiante> obtenerPorPagoMensualMayorQue(@PathVariable("pagoMensual") Double pagoMensual) {
		return estudianteRepository.findByPagoMensualGreaterThan(pagoMensual);
	}
	
	
	
	
	
	
	/*
	 * procedimiento almacenado
	 * y funcion
	 */
	@PostMapping("/guardar3")
	public void guardar3(@RequestBody Estudiante estudiante) {
		estudianteServicio.ejecutarProcedimiento(estudiante);
	}
	@PostMapping("/guardar4")
	public Object guardar4(@RequestBody Estudiante estudiante) {
		return estudianteServicio.ejecutarFuncion(estudiante);
	}
	
	@GetMapping("/join")
	public List<Map<String,Object>> join() {
		return estudianteServicio.ejecutarJoin();
	}
	
	
	
}
