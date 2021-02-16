package br.com.hightechcursos.teste;

import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbcPostgre.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {

		//testCadastrar();
		// testAlterar();
		testeExcluir();
		//testeBuscarTodos();
		// testAutenticar();
		//testBuscarPorId();
		
	}

	private static void testCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Marco");
		usu.setLogin("mmm");
		usu.setSenha("mm123");

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}

	private static void testAlterar() {
		Usuario usu = new Usuario();
		usu.setNome("Jao da Silva");
		usu.setLogin("js");
		usu.setSenha("js123");
		usu.setId(5);

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usu);
	}

	private static void testeExcluir() {
		Usuario usu = new Usuario();
		usu.setId(9);

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usu);
	}

	private static void testeBuscarTodos() {

		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> listaResultado = usuDao.buscarTodos();

		for (Usuario u : listaResultado) {
			System.out.println(u.getId() + " " + u.getNome() + " " + u.getLogin() + " " + u.getSenha());
		}
	}

	public static void testAutenticar() {
		Usuario usu = new Usuario();
		usu.setLogin("juju");
		usu.setSenha("ju123");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.altenticar(usu));
	}

	public static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario retorno = usuarioDAO.buscarId(6);
		if (retorno != null) {
			System.out.println("nome: " + retorno.getNome());
		}else {
			System.out.println("Este usuário não existe");
		}
	}
}
