
package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name = "FOTO" )
public class Foto implements Serializable {
	
	private static final long serialVersionUID = -2078623934848641927L;
	
	@Id
	@Column(name="ID")
	@SequenceGenerator( name="fotoSeq", sequenceName = "FOTO_SEQ", initialValue = 1, allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "fotoSeq" )
	private Long id;
	
	@Column( name = "ANCHO" )
	private Long ancho;
	
	@Column( name = "ALTO" )
	private Long alto;
	
	@Column( name = "NOMBRE" )
	private String nombre;
	
	@ManyToOne
	private Album album;
	
	public Foto() {
	}
	public Foto(Long ancho, Long alto, String nombre) {
		this.ancho = ancho;
		this.alto = alto;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAncho() {
		return ancho;
	}

	public void setAncho(Long ancho) {
		this.ancho = ancho;
	}

	public Long getAlto() {
		return alto;
	}

	public void setAlto(Long alto) {
		this.alto = alto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
