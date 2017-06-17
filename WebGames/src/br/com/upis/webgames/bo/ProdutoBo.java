package br.com.upis.webgames.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.upis.webgames.dao.ProdutoDao;
import br.com.upis.webgames.entidade.Produto;

public class ProdutoBo {

	public ProdutoBo() {

	}

	Produto produto = new Produto();

	public List<Produto> listaBo() throws ClassNotFoundException, SQLException {
		ProdutoDao dao = new ProdutoDao();
		return dao.listaDao();
	}

	public Produto selectProdutoIdBo(int id) throws ClassNotFoundException, SQLException {
		ProdutoDao prodDao = new ProdutoDao();
		return prodDao.selectProdutoDao(id);

	}

	public void insertProdutoBo(Produto produto) throws ClassNotFoundException, SQLException {
		if (validaInfoProduto(produto)) {
			System.out.println("caiu qualquer coisa");
			ProdutoDao usuDao = new ProdutoDao();
			usuDao.insertProdutoDao(produto);
		} else {
			System.out.println("Cadastro não efetuado!");
		}
	}

	public void updateProdutoBo(Produto produto) throws ClassNotFoundException, SQLException {
		if (validaInfoProduto(produto)) {
			ProdutoDao usuDao = new ProdutoDao();
			usuDao.updateProdutoDao(produto);
		}

	}

	public void deleteProdutoBo(Produto produto) throws ClassNotFoundException, SQLException {
		ProdutoDao usuDao = new ProdutoDao();
		usuDao.deleteProdutoDao(produto);
	}

	private boolean validaInfoProduto(Produto produto) {

		return true;
	}

	public String formataValor(String str) {
		String valor = "";
		char[] vetor = str.toCharArray();
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == ',') {
				vetor[i] = '.';
				valor += vetor[i];
			} else {
				valor += vetor[i];
			}
		}

		return valor;
	}

	public List<Produto> selectProdutoNomeBo(String nome) throws ClassNotFoundException, SQLException {
		ProdutoDao prodDao= new ProdutoDao();
		return prodDao.searchProdutoDao(nome);
	}


}
