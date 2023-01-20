
package com.rodriguez.db.entity;

import java.io.Serializable;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import lombok.Getter;
//import lombok.Setter;

@Entity(name="PRODUCTO")
@Table(name="PRODUCTO")
/*
@SequenceGenerator(
	    name="ProductoSEQ",
	    sequenceName = "PRODUCTOSEQ",
	    initialValue = 1, 
	    allocationSize = 10
)
*/
//@Getter @Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 2393546991961155509L;
	
	
	/*
	public Producto() {}
	public Producto(String nombre, Double precio, Long stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	*/

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@EmbeddedId
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PRECIO")
	private Double precio;
	
	@Column(name="STOCK")
	private Long stock;
	
	
	@MapsId("categoria_id")
	@ManyToOne
	/*
	@ManyToOne(
		optional=true,
		cascade=CascadeType.ALL,
		//cascade={CascadeType.PERSIST,CascadeType.MERGE},
		fetch=FetchType.EAGER
	)
	*/
	@JoinColumn
	/*
	@JoinColumn(
			name="categoria_fk",// nombre de la foreignKey
			updatable=true,
			insertable=true,
			referencedColumnName="id",// columnaId de la otra tabla
			nullable=true
	)
	*/
	//@JsonIgnore
    private Categoria categoria;

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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
} // Producto M - 1 Categoria
