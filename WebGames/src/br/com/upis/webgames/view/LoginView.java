package br.com.upis.webgames.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.upis.webgames.bo.UsuarioBo;
import br.com.upis.webgames.entidade.Usuario;

public class LoginView extends HttpServlet {
	private String acao = null;

	public LoginView() {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usu = new Usuario();
		UsuarioBo bo = new UsuarioBo();

		acao = request.getParameter("acao");
System.out.println("não era para cair aqui!");
		if (acao.equals("Logar")) {

			usu.setEmail(request.getParameter("email"));
			usu.setSenha(request.getParameter("senha"));
			try {
				if (bo.autenticaLogin(usu)) {
					usu = bo.permissaoBo(usu);
					HttpSession session = request.getSession();
					session.setAttribute("usuarioLogado", usu);
					if (usu.getTipo().equals("Administrador") || usu.getTipo().equals("Funcionario")) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
						dispatcher.forward(request, response);
					} else if (usu.getTipo().equals("Cliente")) {
						System.out.println(usu.getNome());
						RequestDispatcher dispatcher = request.getRequestDispatcher("/produto?escolha=Listar");
						dispatcher.forward(request, response);
					}
				} else {
					System.out.println("Usuario não cadastrado no banco!");
					String str = "Login - email incorreto ou usuário não cadastrado no banco de dados!";
					request.setAttribute("mensagem", str);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/paginas/mensagemErroLogar.jsp");
					dispatcher.forward(request, response);

					// Colocar aqui algum tratamento de erro caso o usuário não
					// tenha cadastro no site!
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (acao.equals("Deslogar")) {
			request.getSession().removeAttribute("usuarioLogado");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
			dispatcher.forward(request, response);
		}
		if (acao.equals("Cadastrar")) {

			response.sendRedirect("../WebGames/paginas/usuario/adicionaUsuario.jsp");

		}

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = null;
		acao = request.getParameter("acao");
		if (acao.equals("Deslogar")) {
			request.getSession().removeAttribute("usuarioLogado");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
			dispatcher.forward(request, response);
		}
		
	}
}
