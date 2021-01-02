package com.distribuidora.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.distribuidora.dao.ClienteDAO;
import com.distribuidora.modelo.Cliente;
import com.distribuidora.util.jpa.Transactional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Transactional
	public void salvar(Cliente cliente) throws NegocioException {
		this.clienteDAO.salvar(cliente);
	}

}
