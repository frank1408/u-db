
package com.rodriguez.db.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="CATEGORIA")
//@Getter
//@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categoria implements Serializable {

	private static final long serialVersionUID = 3641062092193546961L;

	@Id
	@Column(name="ID")
	@SequenceGenerator(
	    name="jcategoria_seq",// nombre para usarlo en java
	    sequenceName = "categoria_seq",// nombre real en db
	    initialValue = 1, 
	    allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "jcategoria_seq"
	)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(
			mappedBy="categoria",
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			orphanRemoval = false
	)
	private final Set<Producto> productos = new HashSet<>();

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
	public Set<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(Set<Producto> productos) {
		//This will override the set/list that Hibernate is tracking.
		//
		//		this.productos = productos;
		//
		//This will override the set/list that Hibernate is tracking.
		this.productos.clear();
		if( productos != null ) {
			this.productos.addAll(productos);
		}
	}
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
	public void removeProducto(Producto producto) {
		productos.remove(producto);
	}
} // Categoria 1 - M Producto
