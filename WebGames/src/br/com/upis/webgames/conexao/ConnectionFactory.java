package br.com.upis.webgames.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String user = "root";
	String pass = "root1234";

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/WebGames?" + "user=" + user + "&password=" + pass);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}
}
