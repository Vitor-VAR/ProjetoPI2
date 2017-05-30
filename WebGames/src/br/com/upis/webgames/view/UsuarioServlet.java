package br.com.upis.webgames.view;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.upis.webgames.bo.UsuarioBo;
import br.com.upis.webgames.entidade.Usuario;

public class UsuarioServlet extends HttpServlet {

	public UsuarioServlet() {
		// TODO Auto-generated constructor stub
	}

	private String acao = null;
	private String id = null;
	private String escolha = null;
	Usuario usuario = new Usuario();
	UsuarioBo usuBo = new UsuarioBo();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		acao = request.getParameter("acao");

		if (acao.equals("Inserir")) {

			usuario.setNome(request.getParameter("nome"));
			usuario.setSobrenome(request.getParameter("sobrenome"));
			usuario.setSexo(request.getParameter("sexo"));
			usuario.setCpf(request.getParameter("cpf"));
			usuario.setEndereco(request.getParameter("endereco"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setTipo(request.getParameter("tipo"));

			try {
				usuBo.insertUsuarioBo(usuario);
				request.setAttribute("usuario", usuario);
				RequestDispatcher di = request.getRequestDispatcher("/UsuarioEscolha.jsp");
				di.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (acao.equals("Alterar")) {
			usuario.setId(Integer.parseInt(request.getParameter("id")));
			usuario.setNome(request.getParameter("nome"));
			usuario.setSobrenome(request.getParameter("sobrenome"));
			usuario.setCpf(request.getParameter("cpf"));
			usuario.setSexo(request.getParameter("sexo"));
			usuario.setEndereco(request.getParameter("endereco"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setTipo(request.getParameter("tipo"));
			try {
				usuBo.updateUsuarioBo(usuario);
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("/mensagemUpdate.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao.equals("Consultar")) {
			try {
				usuario = usuBo.selectUsuarioIdBo(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("/resultadoConsulta.jsp").forward(request, response);

			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
		if (acao.equals("Voltar")) {
			request.setAttribute("usuario", usuario);
			RequestDispatcher di = request.getRequestDispatcher("/UsuarioEscolha.jsp");
			di.forward(request, response);

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		escolha = request.getParameter("escolha");

		if (escolha.equals("Consultar")) {
			response.sendRedirect("consultaUsuario.jsp");
		}
		if (escolha.equals("opcaoInserir")) {
			response.sendRedirect("adicionaUsuario.jsp");
		}
		if (escolha.equals("Listar")) {
			List<Usuario> Lista = new ArrayList<>();
			UsuarioBo usuBo = new UsuarioBo();
			try {
				Lista = usuBo.listaBo();
				RequestDispatcher rd = request.getRequestDispatcher("/listaUsuario.jsp");
				request.setAttribute("usuarioLista", Lista);
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (escolha.equals("opcaoAlterar")) {
			try {
				usuario = usuBo.selectUsuarioIdBo(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("usu", usuario);
				request.getRequestDispatcher("/alteraUsuario.jsp").forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		if (escolha.equals("Excluir")) {

			try {
				usuario.setId(Integer.parseInt(request.getParameter("id")));
				String str = request.getParameter("nome");
				usuBo.deleteUsuarioBo(usuario);
				request.setAttribute("nome", str);
				request.getRequestDispatcher("/listaUsuario.jsp").forward(request, response);
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
