package com.udemy.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.udemy.app.models.dao.IClienteDao;
import com.udemy.app.models.entity.Cliente;

import jakarta.validation.Valid;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping(path = {"/listar", "/"})
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de cliente");
		
		return "form";
	}
	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		clienteDao.save(cliente);
		return "redirect:listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		if(!clienteDao.findIfExist(id)) return "redirect:/listar";
		
		Cliente cliente = clienteDao.findOne(id);
		model.put("cliente", cliente);
		model.put("titulo", "Editando cliente número " + String.join(" ", cliente.getNombre(), cliente.getApellidos()));
		
		return "editar";
	}
	
	@PostMapping("/actualizarCliente")
	public String updateClient(@Valid Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("Hay errores ya pensaremos como solucionarlo");
			model.addAttribute("titulo", "Editando cliente número "+ String.join(" ", cliente.getNombre(), cliente.getApellidos()));
			return "";
		}
		clienteDao.updateClient(cliente);
		return "redirect:listar";
	}

	@GetMapping("/borrar/{id}")
	public String eliminarCliente(@PathVariable( value = "id" ) Long id, Map<String, Object> model ) {
		
		if(!clienteDao.findIfExist(id)) return "redirect:/listar";
		
		Cliente cliente = clienteDao.findOne(id);
		model.put("titulo", "Borrar Cliente");
		model.put("cliente", cliente);
		
		return "borrar";
	}
	
	@PostMapping("/borrarCliente/{id}")
	public String borrar (@PathVariable(value = "id") Long id) {
		Cliente cliente = clienteDao.findOne(id);
		clienteDao.delete(cliente);
		return "redirect:/listar";
	}
	
}
