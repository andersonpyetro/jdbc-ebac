package test.br.com.pyetro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.pyetro.dao.ClienteDAO;
import br.com.pyetro.dao.IClienteDAO;
import br.com.pyetro.domain.Cliente;

public class ClienteTest {

	private IClienteDAO clienteDAO;

	@Test
	public void cadastrarTest() throws Exception {
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Anderson Pyetro");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteDB = clienteDAO.buscar("10");
		assertNotNull(clienteDB);
		assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
		assertEquals(cliente.getNome(), clienteDB.getNome());

		Integer countDel = clienteDAO.excluir(clienteDB);
		assertTrue(countDel == 1);
	}

	@Test
	public void buscarTest() throws Exception {
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Anderson Pyetro");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteDB = clienteDAO.buscar("10");
		assertNotNull(clienteDB);
		assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
		assertEquals(cliente.getNome(), clienteDB.getNome());

		Integer countDel = clienteDAO.excluir(clienteDB);
		assertTrue(countDel == 1);
	}

	@Test
	public void excluirTest() throws Exception {
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Anderson Pyetro");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteDB = clienteDAO.buscar("10");
		assertNotNull(clienteDB);
		assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
		assertEquals(cliente.getNome(), clienteDB.getNome());

		Integer countDel = clienteDAO.excluir(clienteDB);
		assertTrue(countDel == 1);
	}

	@Test
	public void buscarTodos() throws Exception {
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Anderson Pyetro");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		clienteDAO = new ClienteDAO();

		Cliente cliente1 = new Cliente();
		cliente.setCodigo("11");
		cliente.setNome("Anderson Oliveira");
		Integer countCad1 = clienteDAO.cadastrar(cliente1);
		assertTrue(countCad1 == 1);

		List<Cliente> list = clienteDAO.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());

		int countDel = 0;
		for (Cliente cli : list) {
			clienteDAO.excluir(cli);
			countDel++;
		}
		assertEquals(list.size(), countDel);

		list = clienteDAO.buscarTodos();
		assertEquals(list.size(), 0);
	}

	@Test
	public void atualizarTest() throws Exception {
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Anderson Pyetro");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteDB = clienteDAO.buscar("10");
		assertNotNull(clienteDB);
		assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
		assertEquals(cliente.getNome(), clienteDB.getNome());

		clienteDB.setCodigo("11");
		clienteDB.setNome("Anderson Nobrega");
		Integer countUpdate = clienteDAO.atualizar(clienteDB);
		assertTrue(countUpdate == 1);

		Cliente clienteDB1 = clienteDAO.buscar("10");
		assertNull(clienteDB1);

		Cliente clienteDB2 = clienteDAO.buscar("11");
		assertNotNull(clienteDB2);
		assertEquals(clienteDB.getId(), clienteDB2.getId());
		assertEquals(clienteDB.getCodigo(), clienteDB2.getCodigo());
		assertEquals(clienteDB.getNome(), clienteDB2.getNome());

		List<Cliente> list = clienteDAO.buscarTodos();
		for (Cliente cli : list) {
			clienteDAO.excluir(cli);
		}

	}

}
