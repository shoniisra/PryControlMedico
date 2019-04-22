package com.medico.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.Medico;

public interface IMedicoDAO extends CrudRepository<Medico, Integer> {

	
}
