package com.udemy.app.models.service;

import java.util.List;

import com.udemy.app.models.entity.Cliente;

public interface ICLienteService {

	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public Cliente findOne(Long id);
	
}
