
package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name = "ALBUM" )
public class Album implements Serializable {
	
	private static final long serialVersionUID = 894601599525652794L;
	
	public Album() {
	}
	public Album(String nombre) {
		this.nombre = nombre;
	}
	
	@Id
	@Column(name="ID")
	@SequenceGenerator( name="albumSeq", sequenceName = "ALBUM_SEQ", initialValue = 1, allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "albumSeq" )
	private Long id;
	
	@Column( name = "NOMBRE" )
	private String nombre;

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
}
