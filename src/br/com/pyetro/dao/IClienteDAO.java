package br.com.pyetro.dao;

import java.util.List;

import br.com.pyetro.domain.Cliente;

public interface IClienteDAO {
	
	public Integer cadastrar(Cliente cliente) throws Exception;
	public Integer atualizar(Cliente cliente) throws Exception;
	public Cliente buscar(String codigo) throws Exception;
	public List<Cliente> buscarTodos() throws Exception;
	public Integer excluir(Cliente cliente) throws Exception;

}