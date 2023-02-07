
package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = -2204158727284936301L;
	
	@Id
	@Column(name="ID")
	@SequenceGenerator( name="productoSeq", sequenceName = "PRODUCTO_SEQ", initialValue = 1, allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "productoSeq" )
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@ManyToOne
	private Categoria categoria;
	
	public Producto() {
	}
	public Producto(String nombre) {
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
