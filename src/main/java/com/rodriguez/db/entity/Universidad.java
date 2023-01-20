
package com.rodriguez.db.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
/*
@SequenceGenerator(
	    name="ProductoSEQ",
	    sequenceName = "PRODUCTOSEQ",
	    initialValue = 1, 
	    allocationSize = 10
)
*/
public class Universidad implements Serializable {

	private static final long serialVersionUID = -5815681548941598604L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

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
