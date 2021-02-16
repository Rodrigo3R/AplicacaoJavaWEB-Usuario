package br.com.hightechcursos.jdbcMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;

public class UsuarioDAOmysql {

	private Connection con = DB.getConnection();

	public void cadastrar(Usuario usuario) {
		String sql = "Insert into usuario (nome,login,senha) values (?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			preparador.execute();
			preparador.close();
		
			System.out.println("Cadastrado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usuario) {
		String sql = "Update usuario set nome=? ,login=?, senha=? where id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());

			preparador.execute();
			preparador.close();
		
			System.out.println("Alterado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, usuario.getId());

			preparador.execute();
			preparador.close();
			
			System.out.println("deletado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Usuario> buscarTodos() {
		String sql = "select * from usuario";

		List<Usuario> lista = new ArrayList<Usuario>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Usuario usu = new Usuario();

				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));

				lista.add(usu);
				
			}

			preparador.close();
			System.out.println("buscado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public Usuario buscarId(Integer id) {

		String sql = "select * from usuario where id=?";
		Usuario usu = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				
			}

			System.out.println("buscado id com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usu;

	}

	public List<Usuario> buscarNome(String nome) {

		String sql = "select * from usuario where id=?";
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%" + nome + "%");

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				lista.add(usu);
			}
			
			System.out.println("buscado id com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public Usuario altenticar(Usuario usuario) {

		String sql = "select * from usuario where login =? and senha = ?";
		Usuario usu = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));

			}
	
			System.out.println("Altenticado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usu;

	}

	public Boolean existeUsuario(Usuario usuario) {

		String sql = "select * from usuario where login =? and senha = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());

			ResultSet resultado = preparador.executeQuery();
		
			return resultado.next();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
