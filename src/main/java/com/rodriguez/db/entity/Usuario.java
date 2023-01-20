package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@Table(name="USUARIO")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7833563571614230986L;
	
	@Id
	@Column(name="ID", nullable=false)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	//@GeneratedValue(strategy = GenerationType.UUID)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@Column(name="APELLIDO", nullable=false)
	private String apellido;

	@Column(name="CORREO", nullable=false, unique=true)
	private String correo;
	
	@Column(name="TELEFONO", nullable=false)
	private String telefono;

	
	
	
	
	
	
	
	
	
	
	// constructores
	/*
	public Usuario() {
	}
	public Usuario(String nombree, String apellidoo, String correoo, String telefonoo) {
		this.apellido=apellidoo;
		this.correo=correoo;
		this.nombre=nombree;
		this.telefono=telefonoo;
	}
	*/
	
	
	
	/*
	 	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt; 
	 */
	
	
	
	
	
	
	// get y set
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
} // Usuario
