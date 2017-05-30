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
				RequestDispatcher di = request.getRequestDispatcher("/mensagemInsertProduto.jsp");
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
				request.getRequestDispatcher("/mensagemUpdateProduto.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao.equals("Consultar")) {
			try {
				produto = prodBo.selectProdutoIdBo(Integer.parseInt(request.getParameter("id")));
				System.out.println(produto.getId());
				request.setAttribute("produto", produto);
				request.getRequestDispatcher("/resultadoConsultaProduto.jsp").forward(request, response);

			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
		if (acao.equals("Voltar")) {
			request.setAttribute("produto", produto);
			RequestDispatcher di = request.getRequestDispatcher("/ProdutoEscolha.jsp");
			di.forward(request, response);

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		escolha = request.getParameter("escolha");

		if (escolha.equals("Consultar")) {
			response.sendRedirect("consultaProduto.jsp");
		}
		if (escolha.equals("opcaoInserir")) {
			response.sendRedirect("adicionaProduto.jsp");
		}
		if (escolha.equals("Listar")) {
			List<Produto> Lista = new ArrayList<>();
			ProdutoBo prodBo = new ProdutoBo();
			try {
				Lista = prodBo.listaBo();
				RequestDispatcher rd = request.getRequestDispatcher("/listaProduto.jsp");
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
				request.getRequestDispatcher("/alteraProduto.jsp").forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		if (escolha.equals("Excluir")) {

			try {
				produto.setId(Integer.parseInt(request.getParameter("id")));
				String str = request.getParameter("nome");
				prodBo.deleteProdutoBo(produto);
				request.setAttribute("nome", str);
				request.getRequestDispatcher("/mensagemDeleteProduto.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	}
}

		
	


