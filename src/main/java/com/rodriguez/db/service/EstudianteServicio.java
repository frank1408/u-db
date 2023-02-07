
package com.rodriguez.db.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import com.rodriguez.db.entity.Estudiante;

@Service
public class EstudianteServicio {

	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	@Autowired
	JdbcTemplate jt;
	
	public List<Map<String, Object>> buscarPorNombre(String nombre){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE NOMBRE = :NOMBREE";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("NOMBREE", nombre);
		return npjt.queryForList(querySQL, sps);
	}
	
	public void ejecutarProcedimiento(Estudiante estudiante) {
		String querySQL = "call sp_estudiante_insert(?,?,?,?,?,?,?,?)";
		jt.update(querySQL,
			estudiante.getId(),
			estudiante.getNombre(),
			estudiante.getApellido(),
			estudiante.getCorreo(),
			estudiante.getEstatura(),
			estudiante.getGrupoSanguineo(),
			estudiante.getPagoMensual(),
			estudiante.getUniversidad().getId()
		);
	}
	public Object ejecutarFuncion(Estudiante estudiante) {
		String querySQL = "select mifuncionn1(?) from estudiante where id = ?";
		Map<String,Object> res = jt.queryForMap(
			querySQL,
			estudiante.getPagoMensual(),
			estudiante.getId()
		);
		return res.get("MIFUNCIONN1(:1)");
	}
	
	public List<Map<String,Object>> ejecutarJoin(){
		String querySQL = "SELECT count(1),avg(Estudiante.pago_mensual), Universidad.nombre FROM Estudiante INNER JOIN Universidad ON Estudiante.universidad_id = Universidad.id group by Universidad.nombre";
		SqlParameterSource sps = new MapSqlParameterSource();
		return npjt.queryForList(querySQL, sps);
	}
}
