package it.prova.gestioneproprietari.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Automobile> list() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile o) throws Exception {
		// TODO Auto-generated method stub
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Automobile o) throws Exception {
		// TODO Auto-generated method stub
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);

	}

	@Override
	public void delete(Automobile o) throws Exception {
		// TODO Auto-generated method stub
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));

	}
	
	
}
