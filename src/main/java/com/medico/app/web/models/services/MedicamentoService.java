package com.medico.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.app.web.models.dao.IMedicamentoDAO;
import com.medico.app.web.models.entities.Medicamento;

@Service
public class MedicamentoService implements IMedicamentoService {

	@Autowired
	private IMedicamentoDAO dao;
	
	@Override
	public void save(Medicamento medicamento) {
		// TODO Auto-generated method stub
		dao.save(medicamento);
	}

	@Override
	public Medicamento findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Medicamento> findAll() {
		// TODO Auto-generated method stub
		return (List<Medicamento>) dao.findAll();
	}

}
