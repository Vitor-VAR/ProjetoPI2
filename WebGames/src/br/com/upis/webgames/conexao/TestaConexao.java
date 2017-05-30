package br.com.upis.webgames.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.upis.webgames.dao.UsuarioDao;
import br.com.upis.webgames.entidade.Usuario;


public class TestaConexao {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		double valor = 0.00;
		String str = "150,96";
		
		String striing="";
		

		char [] vatr = str.toCharArray();
		for (int i=0; i < vatr.length;i++){
			if(vatr[i]==','){
				vatr [i]= '.'; 
				striing += vatr[i];
			}else{
			striing += vatr[i];
			}
		}
			
		System.out.println(striing);
		valor = Double.parseDouble(striing);
		System.out.println(valor);
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		
		List<Usuario> lista =new ArrayList<>();
		UsuarioDao dao =new UsuarioDao();
		lista= dao.listaDao();
		
		System.out.println(lista);
		
		
		connection.close();
	}
}

