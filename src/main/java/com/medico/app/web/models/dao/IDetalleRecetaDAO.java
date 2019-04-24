package com.medico.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.DetalleReceta;

public interface IDetalleRecetaDAO extends CrudRepository<DetalleReceta, Integer> {

}
