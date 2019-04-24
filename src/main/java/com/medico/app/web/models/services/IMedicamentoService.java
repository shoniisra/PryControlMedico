package com.medico.app.web.models.services;

import java.util.List;

import com.medico.app.web.models.entities.Medicamento;

public interface IMedicamentoService {
	
	public void save(Medicamento medicamento);
	
	public Medicamento findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Medicamento> findAll();

}
