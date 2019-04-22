package com.medico.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="DOSIS")
public class Dosis implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IDDOSIS")
	private Integer iddosis;
	
	
	@Column(name = "FECHAHORA")
	@Temporal(TemporalType.DATE)
	private Calendar fechaHora;
	
	@Column(name = "NUMERO")
	@Min(value = 1)
	private Integer numero;
	
	@Size(max = 255)
	@Column(name = "DESCRIPCION")
	private String descripcion;//justificacion de por qué se interrumpe el tratamiento
	
	@Column(name = "ESTADO")
	@Min(value = 0)
	private Integer estado;
	
	@JoinColumn(name="IDDETALLERECETA", referencedColumnName = "IDDETALLERECETA")
	@ManyToOne
	private DetalleReceta detalleReceta;

	public Dosis() {
		super();
	}

	public Dosis(Integer iddosis) {
		super();
		this.iddosis = iddosis;
	}

	public Integer getIddosis() {
		return iddosis;
	}

	public void setIddosis(Integer iddosis) {
		this.iddosis = iddosis;
	}

	public Calendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Calendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public DetalleReceta getDetalleReceta() {
		return detalleReceta;
	}

	public void setDetalleReceta(DetalleReceta detalleReceta) {
		this.detalleReceta = detalleReceta;
	}
	
	

}
