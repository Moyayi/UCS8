package com.udemy.app.models.dao;

import java.util.List;

import com.udemy.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public void updateClient( Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public boolean findIfExist(Long id);
	


}
