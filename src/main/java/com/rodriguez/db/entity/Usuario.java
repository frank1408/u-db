package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7833563571614230986L;

	public Usuario() {
	}
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@Column(name="APELLIDO", nullable=false)
	private String apellido;

	@Column(name="CORREO", nullable=false)
	private String correo;
	
	@Column(name="TELEFONO", nullable=false)
	private String telefono;

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
} // Persona
