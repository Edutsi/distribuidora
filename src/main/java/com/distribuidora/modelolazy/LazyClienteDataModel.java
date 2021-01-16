package com.distribuidora.modelolazy;

///IMPLEMENTANDO O LAZY LOAD A PAGINAÇÃO FICA ARMAZENADA NO BANCO E NÃO NA MEMÓRIA
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.distribuidora.dao.ClienteDAO;
import com.distribuidora.modelo.Cliente;

public class LazyClienteDataModel extends LazyDataModel<Cliente> implements Serializable {

	private ClienteDAO ClienteDAO;
	
  public LazyClienteDataModel(ClienteDAO ClienteDAO) {
  	this.ClienteDAO = ClienteDAO;
  	
  }
  
  @Override
	public List<Cliente> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		List<Cliente> Clientes = this.ClienteDAO.buscarComPaginacao(first, pageSize);
		
		this.setRowCount(this.ClienteDAO.encontrarQuantidadeDeClientes().intValue());
		
		return Clientes;
	}
}

