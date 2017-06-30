package br.com.upis.webgames.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

import br.com.upis.webgames.bo.ProdutoBo;
import br.com.upis.webgames.bo.UsuarioBo;
import br.com.upis.webgames.bo.VendaBo;
import br.com.upis.webgames.entidade.Carrinho;
import br.com.upis.webgames.entidade.ItemDeCompra;
import br.com.upis.webgames.entidade.Produto;
import br.com.upis.webgames.entidade.Usuario;

public class VendaServlet extends HttpServlet {
	private String acao = null;
	public VendaServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto produto = new Produto();
		ProdutoBo produtoBo = new ProdutoBo();
		Usuario usuario = new Usuario();
		UsuarioBo ususarioBo =new UsuarioBo();
		VendaBo venda =new VendaBo();
		
		acao =request.getParameter("acao");
		
		if(acao.equals("finalizarCompra")){
			
			List <Produto> produtos = new ArrayList<>();
			List<Usuario> usuarios = new ArrayList<>();
			
			
			HttpSession session = request.getSession(true);
			Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
			
			for (ItemDeCompra item : carrinho.getItens()) {
			produto= produto.setId(item.getId());
			usuario= usuario.setId();
			venda = venda.Cadastrar();
			
			}	
		
		
		
		
	
	}
	}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acao = null;
	Produto produto = new Produto();
	ProdutoBo produtoBo = new ProdutoBo();
	
	
		
		
	}
	

}
