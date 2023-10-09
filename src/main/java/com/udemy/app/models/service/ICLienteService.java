package com.udemy.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.udemy.app.models.entity.Cliente;

public interface ICLienteService {

	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable page);
	
	public void save(Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public Cliente findOne(Long id);
	
}
