
package com.rodriguez.db.entity;

import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="UNIVERSIDAD")
//@Getter
//@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Universidad implements Serializable {

	private static final long serialVersionUID = -5815681548941598604L;
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(
	    name="juniversidad_seq",// nombre para usarlo en java
	    sequenceName = "universidad_seq",// nombre real en db
	    initialValue = 1, 
	    allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "juniversidad_seq"
	)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	/*
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(
			mappedBy="universidad",
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			orphanRemoval = false
	)
	private final Set<Estudiante> estudiantes = new HashSet<>();
	*/
	
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
	/*
	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void setEstudiantes(Set<Estudiante> estudiantes) {
		//This will override the set/list that Hibernate is tracking.
		//
		//		this.estudiantes = estudiantes;
		//
		//This will override the set/list that Hibernate is tracking.
		this.estudiantes.clear();
		if( estudiantes != null ) {
			this.estudiantes.addAll(estudiantes);
		}
	}
	
	public void addEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	public void removeEstudiante(Estudiante estudiante) {
		estudiantes.remove(estudiante);
	}
	*/
} // Universidad 1 - M Estudiantes
