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
	private String infoPagina = null;
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
				RequestDispatcher di = request.getRequestDispatcher("/WEB-INF/paginas/mensagemInsert.jsp");
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
				request.getRequestDispatcher("/WEB-INF/paginas/mensagemUpdate.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao.equals("Consultar")) {
			List<Usuario> Lista = new ArrayList<>();
			try {
				Lista = usuBo.selectUsuarioNomeBo(request.getParameter("nome"));
				System.out.println(Lista);
				RequestDispatcher rd = request.getRequestDispatcher("paginas/usuario/resultadoConsulta.jsp");
				request.setAttribute("usuarioLista", Lista);
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		escolha = request.getParameter("escolha");
		infoPagina = request.getParameter("infoPagina");

		if (escolha.equals("Consultar")) {
			response.sendRedirect("../WebGames/paginas/usuario/consultaUsuario.jsp");
		}
		if (escolha.equals("opcaoInserir")) {
			response.sendRedirect("../WebGames/paginas/usuario/adicionaUsuario.jsp");
		}
		if (escolha.equals("Listar")) {
			List<Usuario> Lista = new ArrayList<>();
			UsuarioBo usuBo = new UsuarioBo();
			try {
				Lista = usuBo.listaBo();
				RequestDispatcher rd = request.getRequestDispatcher("paginas/usuario/listaUsuario.jsp");
				request.setAttribute("usuarioLista", Lista);
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (escolha.equals("opcaoAlterar")) {
			usuario = usuBo.selectUsuarioIdBo(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("usu", usuario);
			request.getRequestDispatcher("paginas/usuario/alteraUsuario.jsp").forward(request, response);
		}
		if (escolha.equals("Excluir")) {

			try {

				usuario.setId(Integer.parseInt(request.getParameter("id")));
				String str = request.getParameter("nome");
				str += " foi excluído com sucesso!";
				usuBo.deleteUsuarioBo(usuario);
				request.setAttribute("nome", str);
				if (infoPagina.equals("listar")) {
					request.getRequestDispatcher("/listaUsuario?escolha=Listar").forward(request, response);
				} else if (infoPagina.equals("consultar")) {
					request.getRequestDispatcher("paginas/usuario/resultadoConsulta.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
