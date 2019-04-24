package com.medico.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.Dosis;

public interface IDosisDAO extends CrudRepository<Dosis, Integer> {

}
