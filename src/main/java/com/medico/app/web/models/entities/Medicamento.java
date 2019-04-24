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
@Table(name="MEDICAMENTO")
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IDMEDICAMENTO")
	private Integer idmedicamento;
	
	
	@Column(name = "VIAADMINISTRACION")
	@Size(max = 255)
	private String viaAdministracion;
	
	@Column(name = "NOMBRECOMERCIAL")
	@Size(max = 255)
	private String nombreComercial;
	
	@Column(name = "PRECIO")
	private float precio;
	
	@Column(name = "CONCENTRACION")
	@Size(max = 255)
	private String concentracion;
	
	@OneToMany(mappedBy="medicamento", fetch=FetchType.LAZY)
	private List<DetalleReceta> detalles;

	public Medicamento() {
		super();
	}

	public Medicamento(Integer idmedicamento) {
		super();
		this.idmedicamento = idmedicamento;
	}

	public Integer getIdmedicamento() {
		return idmedicamento;
	}

	public void setIdmedicamento(Integer idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getViaAdministracion() {
		return viaAdministracion;
	}

	public void setViaAdministracion(String viaAdministracion) {
		this.viaAdministracion = viaAdministracion;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public List<DetalleReceta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleReceta> detalles) {
		this.detalles = detalles;
	}
	

	
	
}
