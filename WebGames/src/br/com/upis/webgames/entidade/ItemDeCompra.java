package br.com.upis.webgames.entidade;

public class ItemDeCompra {

	public ItemDeCompra() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private Produto produto;
	private int quantidade;
	private double total;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getTotal() {
		return this.total = this.quantidade*this.produto.getPreco();
	}
	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
