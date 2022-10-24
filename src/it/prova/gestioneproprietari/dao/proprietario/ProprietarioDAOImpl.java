package it.prova.gestioneproprietari.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Proprietario> list() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return entityManager.find(Proprietario.class, id);
	}

	@Override
	public void update(Proprietario o) throws Exception {
		// TODO Auto-generated method stub
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Proprietario o) throws Exception {
		// TODO Auto-generated method stub
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
		
	}

	@Override
	public void delete(Proprietario o) throws Exception {
		// TODO Auto-generated method stub
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public int contaProprietariAutomobiliAnnoInPoi(Integer annoInput) throws Exception {
		// TODO Auto-generated method stub
		if (annoInput == null) {
			throw new Exception("Problema valore in input");
		}
		TypedQuery<Long> query = entityManager.createQuery("select count(distinct proprietario_id) from Automobile where annoimmatricolazione >= ?1", Long.class);
		query.setParameter(1, annoInput);
		return query.getSingleResult().intValue();
		
	}
	
	
}
