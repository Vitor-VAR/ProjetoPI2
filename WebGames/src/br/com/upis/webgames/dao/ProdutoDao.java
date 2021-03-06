package br.com.upis.webgames.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import br.com.upis.webgames.conexao.ConnectionFactory;
import br.com.upis.webgames.entidade.Produto;


public class ProdutoDao {
	private static Connection connection;
	private Statement statement;

	public ProdutoDao() throws SQLException, ClassNotFoundException {
		connection = new ConnectionFactory().getConnection();
	}

	public boolean insertProdutoDao(Produto produto) {
		String sql = "insert into produto" + "(nome,genero,plataforma,descricao,preco,quantidade)"
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getGenero());
			statement.setString(3, produto.getPlataforma());
			statement.setString(4, produto.getDescricao());
			statement.setDouble(5, produto.getPreco());
			statement.setLong(6, produto.getQuantidade());
			

			boolean resultado = statement.execute();
			System.out.println(resultado);

			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				System.out.println(id + "gerado");
			}
			resultSet.close();
			statement.close();
			connection.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static void updateProdutoDao(Produto produto) {
		String sql = "update produto set idproduto = ? ,nome= ?,genero= ?, plataforma=?,descricao= ?"
				+ ",preco= ?,quantidade= ? where idproduto= ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, produto.getId());
			statement.setString(2, produto.getNome());
			statement.setString(3, produto.getGenero());
			statement.setString(4, produto.getPlataforma());
			statement.setString(5, produto.getDescricao());
			statement.setDouble(6, produto.getPreco());
			statement.setLong(7, produto.getQuantidade());
			statement.setLong(8, produto.getId());

			statement.execute();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean deleteProdutoDao(Produto produto) {

		String sql = "delete from produto where idProduto = ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, produto.getId());
			statement.execute();
			int count = statement.getUpdateCount();
			System.out.println(count + " linha atualizada!");
			statement.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Produto selectProdutoDao(int id) {
		Produto produto = new Produto();

		String sql = "select * from produto where idProduto = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				produto.setId((rs.getInt("idProduto")));
				produto.setNome((rs.getString("nome")));
				produto.setGenero((rs.getString("genero")));
				produto.setPlataforma((rs.getString("plataforma")));
				produto.setDescricao((rs.getString("descricao")));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade((rs.getInt("quantidade")));
			}
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	public  List<Produto> listaDao() {
		List<Produto> selectListaProduto = new ArrayList<>();
		String sql = "select * from produto orderby";
		System.out.println("caiu aqui no m�todo lista dao!");
		try {

			statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId((rs.getInt("idProduto")));
				produto.setNome((rs.getString("nome")));
				produto.setGenero((rs.getString("genero")));
				produto.setPlataforma((rs.getString("plataforma")));
				produto.setDescricao((rs.getString("descricao")));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade((rs.getInt("quantidade")));
				selectListaProduto.add(produto);
			}
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectListaProduto;
	}

	
	public boolean existeProduto(Produto produto) {
		boolean achou = false;
		try {

			PreparedStatement statement = connection.prepareStatement("Select * from produto where idProduto = ?");
			statement.setString(1, produto.getNome());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}

	public List<Produto> searchProdutoDao(String nome) {
		List<Produto> selectListaProduto= new ArrayList<>();
		
		String sql = "select * from produto where nome like ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome +'%');
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId((rs.getInt("idProduto")));
				produto.setNome((rs.getString("nome")));
				produto.setGenero((rs.getString("genero")));
				produto.setPlataforma((rs.getString("plataforma")));
				produto.setDescricao((rs.getString("descricao")));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade((rs.getInt("quantidade")));
				selectListaProduto.add(produto);
			}
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return selectListaProduto;
	}

}
