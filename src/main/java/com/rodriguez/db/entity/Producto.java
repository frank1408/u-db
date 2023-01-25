
package com.rodriguez.db.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="PRODUCTO")
//@Getter
//@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
	
	private static final long serialVersionUID = -2204158727284936301L;

	@Id
	@Column(name="ID")
	@SequenceGenerator(
    name="jproducto_seq",// nombre para usarlo en java
    sequenceName = "producto_seq",// nombre real en db
    initialValue = 1,
    allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "jproducto_seq" //nombre en java
	)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categoria_id", nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categoria categoria;

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
} // Producto M - 1 Categoria
