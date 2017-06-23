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
import javax.servlet.http.HttpSession;

import br.com.upis.webgames.entidade.Produto;
import br.com.upis.webgames.bo.ProdutoBo;;

public class CarrinhoView extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = null;
		List<Produto> listaItem = new ArrayList<>();
		Produto produto = new Produto();
		ProdutoBo produtoBo = new ProdutoBo();

		acao = request.getParameter("acao");

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			System.out.println("passou aqui depois do if");
			HttpSession session = request.getSession(true);
			listaItem = (List<Produto>) session.getAttribute("listaItem");
			session.setAttribute("listaItem", listaItem);
			System.out.println("passou aqui antes do segundo if");
			if (acao.equals("AddNoCarrinho")) {
				System.out.println("entrou no segundo if");
				try {
					produto = produtoBo.selectProdutoIdBo(Integer.parseInt(request.getParameter("id")));
					listaItem.add(produto);
					System.out.println("Passou aqui! ");
					for (Produto prod : listaItem) {
						System.out.println("Produto verificado aqui no for!");
						if (produto.equals(prod)) {
							String msg = "produto já adicionado no carrinho";
							request.setAttribute("mensagem", msg);
							RequestDispatcher rd = request.getRequestDispatcher("/produto?escolha=Listar");
							rd.forward(request, response);
						}
					}

					
					System.out.println("Produto foi adicionado!");
					request.setAttribute("listaItem", listaItem);
					RequestDispatcher rd = request.getRequestDispatcher("/produto?escolha=Listar");
					rd.forward(request, response);

				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (acao.equals("ListarCarrinho")) {
				session.setAttribute("listaItem", listaItem);
				RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
				rd.forward(request, response);
			}
			if (acao.equals("RemoverDoCarrinho")) {
			}

		}
	}
}
