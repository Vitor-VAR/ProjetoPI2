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

import br.com.upis.webgames.entidade.Carrinho;
import br.com.upis.webgames.entidade.ItemDeCompra;
import br.com.upis.webgames.entidade.Produto;
import br.com.upis.webgames.bo.ProdutoBo;

public class CarrinhoView extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = null;
		Produto produto = new Produto();
		ProdutoBo produtoBo = new ProdutoBo();

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			System.out.println("passou aqui depois do if");

			acao = request.getParameter("acao");
			if (acao.equals("AddNoCarrinho")) {
				System.out.println("entrou no segundo if");
				try {
					produto = produtoBo.selectProdutoIdBo(Integer.parseInt(request.getParameter("id")));
					boolean existe = false;
					HttpSession session = request.getSession(true);
					Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
					if (carrinho == null) {
						carrinho = new Carrinho();
						session.setAttribute("carrinho", carrinho);
					}
					if (carrinho.getItens() != null) {
						for (ItemDeCompra item : carrinho.getItens()) {
							if (item.getProduto().equals(produto)) {
								item.setQuantidade(item.getQuantidade() + 1);
								existe = true;
							}
						}
					}
					if (existe == false) {
						produto = produtoBo.selectProdutoIdBo(Integer.parseInt(request.getParameter("id")));
						ItemDeCompra novoItem = new ItemDeCompra();
						novoItem.setProduto(produto);
						novoItem.setQuantidade(1);
						carrinho.addNovoItem(novoItem);
					}
					RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
					rd.forward(request, response);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			 if (acao.equals("RemoveDoCarrinho")) {
				System.out.println("passou depois de remover!");
				HttpSession sessao = request.getSession();
				Carrinho carrinho =(Carrinho) sessao.getAttribute("carrinho");
				int idProduto= Integer.parseInt(request.getParameter("id"));
				
				ItemDeCompra itemRemove =new ItemDeCompra();
				Produto prodRemove = new Produto();
				prodRemove.setId(idProduto);
				itemRemove.setProduto(produto);
				
				carrinho.removerItem(itemRemove);
				RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
				rd.forward(request, response);
				
			}
			if (acao.equals("ListaCarrinho")) {
				RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
				rd.forward(request, response);
			}

		}
	}
}
