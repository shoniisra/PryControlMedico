package com.medico.app.web.models.services;


import com.medico.app.web.models.dao.IDosisDAO;
import com.medico.app.web.models.entities.Dosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DosisService implements IDosisService {

    @Autowired
    private IDosisDAO dao;

    @Override
    public void save(Dosis medicamento) {
        // TODO Auto-generated method stub
        dao.save(medicamento);
    }

    @Override
    public Dosis findById(Integer id) {
        // TODO Auto-generated method stub
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        dao.deleteById(id);
    }

    @Override
    public List<Dosis> findAll() {
        // TODO Auto-generated method stub
        return (List<Dosis>) dao.findAll();
    }

}