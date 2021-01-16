package com.distribuidora.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.distribuidora.modelo.Cliente;
import com.distribuidora.service.NegocioException;
import com.distribuidora.util.jpa.Transactional;

public class ClienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cliente buscarPeloCodigo(Long codigo) {
		return manager.find(Cliente.class, codigo);
	}

	public void salvar(Cliente cliente) {
		manager.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return manager.createQuery("from Cliente").getResultList();
	}

	@Transactional
	public void excluir(Cliente cliente) throws NegocioException {
		cliente = buscarPeloCodigo(cliente.getCodigo());
		try {
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarComPaginacao(int first, int pageSize) {

		return manager.createNamedQuery("Cliente.buscarTodos").setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeClientes() {

		return manager.createQuery("select count(c) from Cliente c", Long.class).getSingleResult();
	}
}
