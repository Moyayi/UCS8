package com.udemy.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;

@Repository
public class ClienteDaoImpl implements IClienteDao {

	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		
		return em.createQuery("from Cliente").getResultList();
	}

}