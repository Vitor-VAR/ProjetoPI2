package br.com.upis.webgames.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.upis.webgames.bo.ProdutoBo;
import br.com.upis.webgames.entidade.Produto;


public class ProdutoServlet extends HttpServlet {

	private String acao = null;
	private String escolha = null;
	private String infoPagina= null;
	Produto produto = new Produto();
	ProdutoBo prodBo = new ProdutoBo();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		acao = request.getParameter("acao");

		if (acao.equals("Inserir")) {
			produto.setNome(request.getParameter("nome"));
			System.out.println(produto.getNome());
			produto.setGenero(request.getParameter("genero"));
			produto.setPlataforma(request.getParameter("plataforma"));
			produto.setDescricao(request.getParameter("descricao")); 
			produto.setPreco(Double.parseDouble(prodBo.formataValor (request.getParameter("valor"))));
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			System.out.println(produto.getPlataforma());
			try {
				prodBo.insertProdutoBo(produto);
				request.setAttribute("produto", produto);
				RequestDispatcher di = request.getRequestDispatcher("paginas/produto/mensagemInsertProduto.jsp");
				di.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (acao.equals("Alterar")) {
			produto.setId(Integer.parseInt(request.getParameter("id")));
			produto.setNome(request.getParameter("nome"));
			produto.setGenero(request.getParameter("genero"));
			produto.setPlataforma(request.getParameter("plataforma"));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setPreco(Double.parseDouble(prodBo.formataValor(request.getParameter("preco"))));
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			
			try {
				prodBo.updateProdutoBo(produto);
				request.setAttribute("produto", produto);
				request.getRequestDispatcher("paginas/produto/mensagemUpdateProduto.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao.equals("Consultar")) {
			try {
				produto = prodBo.selectProdutoIdBo(Integer.parseInt(request.getParameter("id")));
				System.out.println(produto.getId());
				request.setAttribute("produto", produto);
				request.getRequestDispatcher("paginas/produto/resultadoConsultaProduto.jsp").forward(request, response);

			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
		if (acao.equals("Voltar")) {
			request.setAttribute("produto", produto);
			RequestDispatcher di = request.getRequestDispatcher("paginas/produto/ProdutoEscolha.jsp");
			di.forward(request, response);

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		escolha = request.getParameter("escolha");
		infoPagina = request.getParameter("infoPagina");
		

		if (escolha.equals("Consultar")) {
			response.sendRedirect("../WebGames/paginas/produto/consultaProduto.jsp");
		}
		if (escolha.equals("opcaoInserir")) {
			response.sendRedirect("../WebGames/paginas/produto/adicionaProduto.jsp");
		}
		if (escolha.equals("Listar")) {
			List<Produto> Lista = new ArrayList<>();
			ProdutoBo prodBo = new ProdutoBo();
			try {
				Lista = prodBo.listaBo();
				RequestDispatcher rd = request.getRequestDispatcher("paginas/produto/listaProduto.jsp");
				request.setAttribute("produtoLista", Lista);
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (escolha.equals("opcaoAlterar")) {
			try {
				produto = prodBo.selectProdutoIdBo(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("prod", produto);
				request.getRequestDispatcher("paginas/produto/alteraProduto.jsp").forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		if (escolha.equals("Excluir")) {

			try {
				produto.setId(Integer.parseInt(request.getParameter("id")));
				String str = request.getParameter("nome");
				str += " foi excluído com sucesso!";
				prodBo.deleteProdutoBo(produto);
				request.setAttribute("nome", str);
				if (infoPagina.equals("listar")) {
					request.getRequestDispatcher("/listaProduto?escolha=Listar").forward(request, response);
				} else if (infoPagina.equals("consultar")) {
					request.getRequestDispatcher("paginas/produto/resultadoConsultaProduto.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	}
}

		
	


