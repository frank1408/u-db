
package com.rodriguez.db.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="UNIVERSIDAD")
public class Universidad implements Serializable {

	private static final long serialVersionUID = -5815681548941598604L;
	
	@Id
	@Column(name="ID")
	@SequenceGenerator( name="universidadSeq", sequenceName = "UNIVERSIDAD_SEQ", initialValue = 1, allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "universidadSeq" )
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@OneToMany( mappedBy = "universidadId", fetch = FetchType.EAGER, orphanRemoval = false  )
	private final List<Estudiante> estudiantes = new ArrayList<>();
	
	public Universidad() {
	}
	public Universidad(String nombre) {
		this.nombre = nombre;
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
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes.clear();
		if( !estudiantes.isEmpty() ) {
			this.estudiantes.addAll(estudiantes);
		}
	}
	public void addEstudiante(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
	}
	public void removeEstudiante(Estudiante estudiante) {
		this.estudiantes.remove(estudiante);
	}
}
