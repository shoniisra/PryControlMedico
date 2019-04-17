package com.medico.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="MEDICO")
public class Medico extends Persona implements Serializable{

	private static final long serialVersionUID = 1L; //Aplica para serialización

	@Size(max = 35)
	@Column(name = "LICENCIA")
	@NotEmpty
	private String licencia;

	@Size(max = 255)
	@Column(name = "ESPECIALIDAD")
	private String especialidad;
	
	@OneToMany(mappedBy="medico", fetch=FetchType.LAZY)//LAZY, trae los valores de los atributos y no todo el listado 
	private List<Receta> recetas;
	
	
	public Medico() {
		super();
	}

	public Medico(Integer id) {
		super();
		this.setIdpersona(id);
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
}
