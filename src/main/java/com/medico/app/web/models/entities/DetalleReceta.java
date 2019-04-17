package com.medico.app.web.models.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="DETALLERECETA")
public class DetalleReceta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IDDETALLERECETA")
	private Integer iddetalleReceta;
	
	
	@Column(name = "CANTIDAD")
	@Min(value = 1)
	private Integer cantidad;
	
	@Column(name="ACTIVO")
	private Boolean activo;//se está tomando el medicamento o no
	
	@Size(max = 255)
	@Column(name = "OBSERVACION")
	private String observacion;//justificacion de por qué se interrumpe el tratamiento

	@JoinColumn(name="IDRECETA", referencedColumnName = "IDRECETA")
	@ManyToOne
	private Receta receta;
	
	
	public DetalleReceta() {
		super();
	}

	
	
}
