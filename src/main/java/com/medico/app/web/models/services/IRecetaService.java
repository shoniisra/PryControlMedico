package com.medico.app.web.models.services;

import java.util.List;

import com.medico.app.web.models.entities.Receta;


public interface IRecetaService {
//@Transactional en caso de hacer con el primer metodo

	public void save(Receta receta);
	
	public Receta findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Receta> findAll();
}
