package com.medico.app.web.models.services;

import java.util.List;

import com.medico.app.web.models.entities.Medico;

public interface IMedicoService {

	public void save(Medico medico);
	
	public Medico findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Medico> findAll();
}
