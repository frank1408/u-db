package com.rodriguez.db.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ESTUDIANTE")
public class Estudiante implements Serializable {

	private static final long serialVersionUID = -5815681548941598604L;

	@Id
	@Column(name="ID", nullable=false)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@Column(name="APELLIDO", nullable=false)
	private String apellido;

	@Column(name="TELEFONO", nullable=false, unique=true)
	private String telefono;
} // Estudiante
