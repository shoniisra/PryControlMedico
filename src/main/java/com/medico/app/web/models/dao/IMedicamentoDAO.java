package com.medico.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.Medicamento;

public interface IMedicamentoDAO extends CrudRepository<Medicamento, Integer> {

}
