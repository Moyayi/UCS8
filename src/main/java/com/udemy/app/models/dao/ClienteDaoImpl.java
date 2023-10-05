package com.udemy.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
	}
	
	
	@Override
	@Transactional
	public void updateClient(Cliente cliente) {
		em.merge(cliente);
	}
	
	@Override
	@Transactional
	public void delete(Cliente cliente) {
		em.remove(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public boolean findIfExist(Long id) {
		return em.find(Cliente.class, id) == null ? false : true;
	}
	

}
