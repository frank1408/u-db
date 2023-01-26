
package com.rodriguez.db.service;

import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicio {

	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	public List<Map<String, Object>> buscarPorNombre(String nombre){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE NOMBRE = :NOMBRE";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("NOMBRE", nombre);
		return npjt.queryForList(querySQL, sps);
	}
	public List<Map<String, Object>> buscarPorApellido(String apellido){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE APELLIDO = :APELLIDO";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("APELLIDO", apellido);
		return npjt.queryForList(querySQL, sps);
	}
	public List<Map<String, Object>> buscarPorCorreo(String correo){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE CORREO = :CORREO";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("CORREO", correo);
		return npjt.queryForList(querySQL, sps);
	}
	public List<Map<String, Object>> buscarPorEstatura(Double estatura){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE ESTATURA = :ESTATURA";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("ESTATURA", estatura);
		return npjt.queryForList(querySQL, sps);
	}
	public List<Map<String, Object>> buscarPorFechaDeNacimiento(LocalDateTime fechaDeNacimiento){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE FECHA_DE_NACIMIENTO = :fechaDeNacimiento";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("fechaDeNacimiento", fechaDeNacimiento);
		return npjt.queryForList(querySQL, sps);
	}
	public List<Map<String, Object>> buscarPorGrupoSanguineo(String grupoSanguineo){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE GRUPO_SANGUINEO = :GRUPOSANGUINEO";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("GRUPOSANGUINEO", grupoSanguineo);
		return npjt.queryForList(querySQL, sps);
	}
	public List<Map<String, Object>> buscarPorPagoMensual(Double pagoMensual){
		String querySQL = "SELECT * FROM ESTUDIANTE WHERE PAGO_MENSUAL = :PAGOMENSUAL";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("PAGOMENSUAL", pagoMensual);
		return npjt.queryForList(querySQL, sps);
	}
} // EstudianteServicio
