package com.distribuidora.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuidora.dao.ClienteDAO;
import com.distribuidora.modelo.Cliente;
import com.distribuidora.service.NegocioException;
import com.distribuidora.util.jsf.FacesUtil;


@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ClienteDAO clienteDAO;
	
	private List<Cliente> clientes = new ArrayList<>();
	///sem o GET list a baixo não achava o bean e gera erro
	public List<Cliente> getClientes() {
		return clientes;
	}
	private Cliente clienteSelecionado;
	
	
	
	public void excluir() {
		try {
			clienteDAO.excluir(clienteSelecionado);
			this.clientes.remove(clienteSelecionado);
			FacesUtil.addSuccessMessage("Funcionário " + clienteSelecionado.getNome() + " excluido com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		clientes = clienteDAO.buscarTodos();
		
	}

	
}
