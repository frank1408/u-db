package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="USUARIO")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7833563571614230986L;
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(
	name="jusuario_seq",// nombre para usarlo en java
    sequenceName = "universidad_seq",// nombre real en db
    initialValue = 1, 
    allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "jusuario_seq"
	)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="APELLIDO")
	private String apellido;

	@Column(name="CORREO")
	private String correo;
	
	@Column(name="TELEFONO")
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
} // Usuario
