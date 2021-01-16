package com.distribuidora.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name ="Cliente.buscarTodos", query="select c from Cliente c")

})
@DiscriminatorValue("CLIENTE")
public class Cliente extends Pessoa{
	private String apelido;

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	

}
