package com.distribuidora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuidora.dao.FuncionarioDAO;
import com.distribuidora.modelo.Funcionario;
import com.distribuidora.modelolazy.LazyFuncionarioDataModel;
import com.distribuidora.service.NegocioException;
import com.distribuidora.util.jsf.FacesUtil;


@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FuncionarioDAO funcionarioDAO;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	private LazyFuncionarioDataModel lazyFuncionarios;
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	private Funcionario funcionarioSelecionado;
	
	
	
	public void excluir() {
		try {
			funcionarioDAO.excluir(funcionarioSelecionado);
			this.funcionarios.remove(funcionarioSelecionado);
			FacesUtil.addSuccessMessage("Funcionário " + funcionarioSelecionado.getNome() + " excluido com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		//funcionarios = funcionarioDAO.buscarTodos();
		lazyFuncionarios = new LazyFuncionarioDataModel(funcionarioDAO);
		
	}

	public LazyFuncionarioDataModel getLazyFuncionarios() {
		return lazyFuncionarios;
	}

	
}
