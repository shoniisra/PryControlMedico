package com.medico.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="DETALLERECETA")
public class DetalleReceta implements Serializable {
	
	private static final long serialVersionUID = 1L;

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

	@Column(name = "NUMEROTOMAS")
	@Min(value = 1)
	private Integer numeroTomas;
	
	@Column(name = "FRECUENCIA")
	@Min(value = 1)
	private Integer frecuencia;
	
	@Size(max = 255)
	@Column(name = "TIPOFRECUENCIA")
	private String tipoFrecuencia;//justificacion de por qué se interrumpe el tratamiento
	
	@JoinColumn(name="IDRECETA", referencedColumnName = "IDRECETA")//claves foraneas
	@ManyToOne
	private Receta receta;
	
	@JoinColumn(name="IDMEDICAMENTO", referencedColumnName = "IDMEDICAMENTO")//claves foraneas
	@ManyToOne
	private Medicamento medicamento;
	
	@OneToMany(mappedBy="detalleReceta", fetch=FetchType.LAZY) //creo la lista de dosis en detalles receta
	private List<Dosis> dosis;
	
	public DetalleReceta() {
		super();
	}


	public DetalleReceta(Integer iddetalleReceta) {
		super();
		this.iddetalleReceta = iddetalleReceta;
	}


	public Integer getIddetalleReceta() {
		return iddetalleReceta;
	}


	public void setIddetalleReceta(Integer iddetalleReceta) {
		this.iddetalleReceta = iddetalleReceta;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Integer getNumeroTomas() {
		return numeroTomas;
	}


	public void setNumeroTomas(Integer numeroTomas) {
		this.numeroTomas = numeroTomas;
	}


	public Integer getFrecuencia() {
		return frecuencia;
	}


	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}


	public String getTipoFrecuencia() {
		return tipoFrecuencia;
	}


	public void setTipoFrecuencia(String tipoFrecuencia) {
		this.tipoFrecuencia = tipoFrecuencia;
	}


	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}


	public Medicamento getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}


	public List<Dosis> getDosis() {
		return dosis;
	}


	public void setDosis(List<Dosis> dosis) {
		this.dosis = dosis;
	}

	
	
}
