
package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="ESTUDIANTE")
public class Estudiante implements Serializable {
	
	private static final long serialVersionUID = 2393546991961155509L;

	@Id
	@Column(name="ID")
	@SequenceGenerator( name="estudianteSeq", sequenceName = "ESTUDIANTE_SEQ", initialValue = 1, allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "estudianteSeq" )
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="ESTATURA", scale = 2)
	private Double estatura;
		
	@Column(name="GRUPO_SANGUINEO")
	private String grupoSanguineo;

	@Column(name="PAGO_MENSUAL", scale = 2)
	private Double pagoMensual;
	

	@Column(name="UNIVERSIDAD_ID", nullable=false)
	private Long universidadId;
	
	public Estudiante() {
	}
	public Estudiante(
			String nombre,
			String apellido,
			String correo,
			Double estatura,
			String grupoSanguineo,
			Double pagoMensual,
			Long universidadId ) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.estatura = estatura;
		this.grupoSanguineo = grupoSanguineo;
		this.pagoMensual = pagoMensual;
		this.universidadId = universidadId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getUniversidadId() {
		return universidadId;
	}
	public void setUniversidadId(Long universidadId) {
		this.universidadId = universidadId;
	}	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Double getPagoMensual() {
		return pagoMensual;
	}
	public void setPagoMensual(Double pagoMensual) {
		this.pagoMensual = pagoMensual;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
}
