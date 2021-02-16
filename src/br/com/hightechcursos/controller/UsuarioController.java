package br.com.hightechcursos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbcPostgre.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Entrou no GET");
		
		UsuarioDAO userDao = new UsuarioDAO();
		List<Usuario> lista = userDao.buscarTodos();
		
		//Engavetar no request
		request.setAttribute("lista", lista);
		
		// encaminhamento ao JSP
		RequestDispatcher  saida = request.getRequestDispatcher("listausuarios.jsp");
		saida.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("Entrou no Post");

		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");

		Usuario u = new Usuario();
		
		if(id != "") {
			u.setId(Integer.parseInt(id));
		}
		
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);

		UsuarioDAO userDao = new UsuarioDAO();
		//UsuarioDAOmysql userDao = new UsuarioDAOmysql();
		userDao.salvar(u);
		
		// metodo para retorno
		PrintWriter saida = response.getWriter();
		saida.print("Salvo");

	}

}
