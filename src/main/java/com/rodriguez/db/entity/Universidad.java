
package com.rodriguez.db.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	@JsonIgnore
	@OneToMany(
			mappedBy="universidad",
			cascade=CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Estudiante> estudiantes;

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
		this.estudiantes = estudiantes;
	}	
} // Universidad 1 - M Estudiantes
