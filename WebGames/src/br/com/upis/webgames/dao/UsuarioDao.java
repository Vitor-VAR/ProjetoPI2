package br.com.upis.webgames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.upis.webgames.conexao.ConnectionFactory;
import br.com.upis.webgames.entidade.Usuario;

public class UsuarioDao {
	private static Connection connection;
	private Statement statement;

	public UsuarioDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public boolean insertUsuarioDao(Usuario usuario) {
		String sql = "insert into Usuario" + "(nome,sobrenome,sexo,cpf,endereco,email,senha,tipoUsuario)"
				+ "values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getSexo());
			statement.setString(4, usuario.getCpf());
			statement.setString(5, usuario.getEndereco());
			statement.setString(6, usuario.getEmail());
			statement.setString(7, usuario.getSenha());
			statement.setString(8, usuario.getTipo());

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

	public static void updateUsuarioDao(Usuario usuario) {
		String sql = "update usuario set idUsuario = ? ,nome= ?,sobrenome= ?, sexo=?,cpf= ?"
				+ ",endereco= ?,email= ?,senha= ?,tipoUsuario= ? where idUsuario= ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, usuario.getId());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getSobrenome());
			statement.setString(4, usuario.getSexo());
			statement.setString(5, usuario.getCpf());
			statement.setString(6, usuario.getEndereco());
			statement.setString(7, usuario.getEmail());
			statement.setString(8, usuario.getSenha());
			statement.setString(9, usuario.getTipo());
			statement.setLong(10, usuario.getId());

			statement.execute();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean deleteUsuarioDao(Usuario usuario) {

		String sql = "delete from usuario where idUsuario = ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, usuario.getId());
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

	public Usuario selectUsuarioDao(int id) {
		Usuario usuario = new Usuario();

		String sql = "select * from usuario where idUsuario = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipo(rs.getString("tipoUsuario"));
			}
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public  List<Usuario> listaDao() {
		List<Usuario> lista = new ArrayList<>();
		String sql = "select * from usuario orderby";
		System.out.println("caiu aqui no método lista dao!");
		try {

			statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setTipo(rs.getString("senha"));
				usuario.setTipo(rs.getString("tipoUsuario"));
				lista.add(usuario);
			}
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public boolean existeEmailHeSenha(Usuario usuario) {
		boolean achou = false;
		try {

			PreparedStatement statement = connection
					.prepareStatement("Select * from usuario where email = ?and senha= ?");
			statement.setString(1, usuario.getEmail());
			statement.setString(2, usuario.getSenha());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getSenha());
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

	public boolean existeCpf(Usuario usuario) {
		boolean achou = false;
		try {

			PreparedStatement statement = connection.prepareStatement("Select * from usuario where cpf = ?");
			statement.setString(1, usuario.getCpf());
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

}
