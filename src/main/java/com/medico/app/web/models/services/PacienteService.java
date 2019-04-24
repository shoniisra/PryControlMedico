package com.medico.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.app.web.models.dao.IPacienteDAO;
import com.medico.app.web.models.entities.Paciente;

@Service
public class PacienteService implements IPacienteService {

	@Autowired
	private IPacienteDAO dao;
	
	@Override
	public void save(Paciente paciente) {
		// TODO Auto-generated method stub
		dao.save(paciente);
	}

	@Override
	public Paciente findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>) dao.findAll();
	}

}
