
package com.rodriguez.db.entity;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
//import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
import lombok.ToString;

@Entity(name="CATEGORIA")
@Table(name="CATEGORIA")
// @Getter @Setter
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
public class Categoria implements Serializable {

	private static final long serialVersionUID = -5815681548941598604L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="DESCRIPCION")
	private String descripcion;	
	
	@JsonIgnore
	@OneToMany(mappedBy="categoria")
	/*
	@OneToMany(
			fetch=FetchType.EAGER,
			mappedBy="categoria",
			cascade=CascadeType.ALL
			//cascade={CascadeType.PERSIST,CascadeType.REMOVE}
			//cascade={ CascadeType.PERSIST, CascadeType.MERGE }
	)
	*/
	private List<Producto> productos;

	/*
	// constructor
	public Categoria() {}
	public Categoria(String nombree, String descripcionn) {
		this.nombre = nombree;
		this.descripcion = descripcionn;
	}
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
} // Categoria 1 - M Producto
