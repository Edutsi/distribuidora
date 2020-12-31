package com.distribuidora.modelo;

public enum Funcao {

	ADMINISTRADOR("Administrador"),
	GERENTE("Gerente"),
	ATENDENTE("Atendente");
	
	private String descricao;
	
	Funcao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
