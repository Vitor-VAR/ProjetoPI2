package br.com.upis.webgames.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.upis.webgames.bo.UsuarioBo;
import br.com.upis.webgames.entidade.Usuario;

public class LoginView extends HttpServlet {
	private String acao = null;

	public LoginView() {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usu = new Usuario();
		UsuarioBo bo = new UsuarioBo();

		acao = request.getParameter("acao");

		if (acao.equals("Logar")) {

			usu.setEmail(login);
			usu.setSenha(senha);
			try {
				if (bo.autenticaLogin(usu)) {
					request.setAttribute("email", usu);
					RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/usuario/UsuarioEscolha.jsp");
					dispatcher.forward(request, response);

				} else {
					System.out.println("Usuario não cadastrado no banco!");
					response.sendRedirect("../WebGames/paginas/usuario/mensagemErroLogar.jsp");
					// Colocar aqui algum tratamento de erro caso o usuário não
					// tenha cadastro no site!
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("Cadastrar")) {

			response.sendRedirect("../WebGames/paginas/usuario/adicionaUsuario.jsp");

		}

	}
}
