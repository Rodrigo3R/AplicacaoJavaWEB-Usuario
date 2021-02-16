package br.com.hightechcursos.jdbcPostgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.hightechcursos.jdbcMysql.DbException;

public class ConexaoPostgre {

	

	public static Connection getConnection() {
		Connection con = null;
		// caminho do banco + usuario + senha
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco_cjweb1", "postgres", "1234567");
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não pode conectar: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado");
			//e.printStackTrace();
		}
		return con;
	}



}
