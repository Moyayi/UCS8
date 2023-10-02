package com.udemy.app.models.dao;

import java.util.List;

import com.udemy.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
}
