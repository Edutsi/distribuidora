package com.distribuidora.controller;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuidora.modelo.Cliente;
import com.distribuidora.modelo.Sexo;
import com.distribuidora.service.CadastroClienteService;
import com.distribuidora.service.NegocioException;
import com.distribuidora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private List<Sexo> sexos;
	
	public List<Sexo> getSexos() {
		return sexos;
	}
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.sexos = Arrays.asList(Sexo.values());

	}
	
	public void salvar() {
		try {
			this.cadastroClienteService.salvar(cliente);
			FacesUtil.addSuccessMessage("Cliente salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
