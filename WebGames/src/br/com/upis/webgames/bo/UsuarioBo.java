package br.com.upis.webgames.bo;

import java.util.List;

import br.com.upis.webgames.dao.UsuarioDao;
import br.com.upis.webgames.entidade.Usuario;

import java.sql.SQLException;

public class UsuarioBo {

	public UsuarioBo() {

	}

	Usuario usuario = new Usuario();

	public boolean autenticaLogin(Usuario usu) throws ClassNotFoundException, SQLException {
		UsuarioDao usuDao = new UsuarioDao();
		if (usuDao.existeEmailHeSenha(usu))
			return true;
		else
			return false;
	}

	public Usuario permissaoTipoUsuarioBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDao usuDao = new UsuarioDao();
		usuario = usuDao.subirLoginDao(usuario.getEmail());
		return usuario;
	}

	private boolean validaEmailUsuarioBo(Usuario usuario) {
		String email = usuario.getEmail();
		return (email.indexOf('@') == 0);
	}

	private boolean validaCpfUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDao usuDao = new UsuarioDao();
		if (usuDao.existeCpf(usuario)) {
			System.out.println("Cpf já cadastrado no banco!");
			return false;
		}

		return true;
	}

	private boolean validaInfoUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		if (validaCpfUsuario(usuario) && validaEmailUsuarioBo(usuario)) {
		}
		return true;
	}

	public List<Usuario> listaBo() throws ClassNotFoundException, SQLException {
		UsuarioDao dao = new UsuarioDao();
		return dao.listaDao();
	}

	public Usuario selectUsuarioIdBo(int id) throws ClassNotFoundException, SQLException {
		UsuarioDao usuDao = new UsuarioDao();
		return usuDao.selectUsuarioDao(id);

	}

	public void insertUsuarioBo(Usuario usu) throws ClassNotFoundException, SQLException {
		if (validaInfoUsuario(usu)) {
			System.out.println("caiu qualquer coisa");
			UsuarioDao usuDao = new UsuarioDao();
			usuDao.insertUsuarioDao(usu);
		} else {
			System.out.println("Cadastro não efetuado!");
		}
	}

	public void updateUsuarioBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		if (validaInfoUsuario(usuario)) {
			UsuarioDao usuDao = new UsuarioDao();
			usuDao.updateUsuarioDao(usuario);
		}

	}

	public void deleteUsuarioBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.deleteUsuarioDao(usuario);
	}

}
