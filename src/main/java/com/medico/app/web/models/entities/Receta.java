package com.medico.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RECETA")
public class Receta implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IDRECETA")
	private Integer idreceta;
	
	@Column(name = "NACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	@JoinColumn(name="IDMEDICO", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Medico medico;
	
	@JoinColumn(name="IDPACIENTE", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Paciente paciente;
	
	@OneToMany(mappedBy="receta", fetch=FetchType.LAZY)
	private List<DetalleReceta> detalles;
	
	public Receta() {
		
	}

	public Receta(Integer idreceta) {
		super();
		this.idreceta = idreceta;
	}

	public Integer getIdreceta() {
		return idreceta;
	}

	public void setIdreceta(Integer idreceta) {
		this.idreceta = idreceta;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<DetalleReceta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleReceta> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
