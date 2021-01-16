package com.distribuidora.modelolazy;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.distribuidora.dao.FuncionarioDAO;
import com.distribuidora.modelo.Funcionario;

public class LazyFuncionarioDataModel extends LazyDataModel<Funcionario> implements Serializable {

	private FuncionarioDAO FuncionarioDAO;
	
  public LazyFuncionarioDataModel(FuncionarioDAO FuncionarioDAO) {
  	this.FuncionarioDAO = FuncionarioDAO;
  	
  }
  
  @Override
	public List<Funcionario> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		List<Funcionario> Funcionarios = this.FuncionarioDAO.buscarComPaginacao(first, pageSize);
		
		this.setRowCount(this.FuncionarioDAO.encontrarQuantidadeDeFuncionarios().intValue());
		
		return Funcionarios;
	}
}

