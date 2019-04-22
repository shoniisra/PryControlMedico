package com.medico.app.web.models.dao;

import java.util.List;

import com.medico.app.web.models.entities.Receta;

public interface IRecetaDAO {

	//CRUD
	public void create(Receta receta);
	
	public Receta retrieve(Integer id);
	
	public void update(Receta receta);
	
	public void delete(Integer id);
	
	//
	
	public List<Receta> list();

}
