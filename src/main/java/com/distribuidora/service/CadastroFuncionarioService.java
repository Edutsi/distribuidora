package com.distribuidora.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.distribuidora.dao.FuncionarioDAO;
import com.distribuidora.modelo.Funcionario;
import com.distribuidora.util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		this.funcionarioDAO.salvar(funcionario);
	}

}
