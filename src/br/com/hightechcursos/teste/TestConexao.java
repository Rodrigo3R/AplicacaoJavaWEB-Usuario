package br.com.hightechcursos.teste;

//import java.sql.Connection;
//import br.com.hightechcursos.jdbcMysql.DB;
import br.com.hightechcursos.jdbcPostgre.ConexaoPostgre;

public class TestConexao {

	public static void main(String[] args) {

		// conecta com o postgre
		ConexaoPostgre.getConnection();
	

		// conecta com o mysql
		// Connection conn = DB.getConnection();
		// DB.closeConnection();

	}

}
