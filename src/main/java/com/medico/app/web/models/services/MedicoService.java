package com.medico.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.app.web.models.dao.IMedicoDAO;
import com.medico.app.web.models.entities.Medico;

@Service
public class MedicoService implements IMedicoService {

	@Autowired
	private IMedicoDAO dao;
	
	@Override
	public void save(Medico medico) {

		dao.save(medico);
	}

	@Override
	public Medico findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Medico> findAll() {
		return (List<Medico>) dao.findAll();

	}

}
