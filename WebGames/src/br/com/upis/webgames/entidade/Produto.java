package br.com.upis.webgames.entidade;

public class Produto {

	public Produto() {
	
	}
	private int id;
	private String nome;
	private String descricao;
	private String genero;
	private String plataforma;
	private double preco;
	private int quant;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nomeProduto) {
		this.nome = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricaoProduto) {
		this.descricao = descricaoProduto;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String generoProduto) {
		this.genero = generoProduto;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataformaProduto) {
		this.plataforma = plataformaProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double valorProduto) {
		this.preco = valorProduto;
	}
	public int getQuantidade() {
		return quant;
	}
	public void setQuantidade(int quantProduto) {
		this.quant = quantProduto;
	}
	public int getId() {
		return id;
	}
	public void setId(int idProduto) {
		this.id = idProduto;
	}
	
	@Override
	public String toString() {
		return "Produto [id= "+id+", Nome= "+nome+", Descricao= "+descricao+", Genero= "+genero+", Plataforma= "+plataforma+",Preço= "
				+preco+",Quantidade= "+quant+"]";
	}
	
	
}
