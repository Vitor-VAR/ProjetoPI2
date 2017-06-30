package br.com.upis.webgames.entidade;

import java.sql.Date;

public class Venda {

	public Venda() {
		// TODO Auto-generated constructor stub
	}
    
	private int IdVenda;
	private Usuario usuario = new Usuario();
	private Produto produto =new Produto();
	private Date data;
	

	public int getIdVenda() {
		return IdVenda;
	}
	public void setIdVenda(int idVenda) {
		IdVenda = idVenda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

	
	
	
}
