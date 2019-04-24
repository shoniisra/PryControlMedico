package com.medico.app.web.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.Receta;

public interface IRecetaDAO extends CrudRepository<Receta, Integer> {


}
