
package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="ESTUDIANTE")
/*
@SequenceGenerator(
	    name="ProductoSEQ",
	    sequenceName = "PRODUCTOSEQ",
	    initialValue = 1, 
	    allocationSize = 10
)
*/
//@Getter
//@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante implements Serializable {
	
	private static final long serialVersionUID = 2393546991961155509L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	//@MapsId("universidad_id")
	@ManyToOne()
	@JoinColumn(name="universidad_id")
	private Universidad universidad;

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
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
} // Estudiantes M - 1 Universidad
