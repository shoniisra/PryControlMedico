package com.medico.app.web.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.medico.app.web.models.dao.IRecetaDAO;
import com.medico.app.web.models.entities.Receta;

@Repository
public class RecetaService implements IRecetaDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Receta receta) {
		em.persist(receta);
	}

	@Override
	public Receta retrieve(Integer id) {
		return em.find(Receta.class, id);
	}

	@Override
	public void update(Receta receta) {
		em.merge(receta);
	}

	@Override
	public void delete(Integer id) {
		em.remove(this.retrieve(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Receta> list() {
		return (List<Receta>)em.createQuery("from Receta").getResultList();
	}

}
