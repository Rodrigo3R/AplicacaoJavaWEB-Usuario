package br.com.hightechcursos.teste;

import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbcMysql.UsuarioDAOmysql;
import br.com.hightechcursos.jdbcPostgre.UsuarioDAO;

public class TestConexaoMysql {

	public static void main(String[] args) {
	
		//testeBuscarTodos();
		testCadastrar();

	}
	
	private static void testeBuscarTodos() {

		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> listaResultado = usuDao.buscarTodos();

		for (Usuario u : listaResultado) {
			System.out.println(u.getId() + " " + u.getNome() + " " + u.getLogin() + " " + u.getSenha());
		}
	}
	
	private static void testCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Pedro");
		usu.setLogin("pp");
		usu.setSenha("pp123");

		UsuarioDAOmysql usuDao = new UsuarioDAOmysql();
		usuDao.cadastrar(usu);
	}

}
