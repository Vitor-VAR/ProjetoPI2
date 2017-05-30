package br.com.upis.webgames.entidade;

//import java.util.Calendar;

public class Usuario {

	public Usuario() {
	}
private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String email;
	private String endereco;
	private String senha;
	private String tipo;

	

	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeUsuario) {
		this.nome = nomeUsuario;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenomeUsuario) {
		this.sobrenome = sobrenomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfUsuario) {
		this.cpf = cpfUsuario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexoUsuario) {
		this.sexo = sexoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailUsuario) {
		this.email = emailUsuario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String enderecoUsuario) {
		this.endereco = enderecoUsuario;
	}

	/*
	 * public Calendar getDataNasc() { return dataNasc; }
	 * 
	 * public void setDataNasc(Calendar dataNasc) { this.dataNasc = dataNasc; }
	 */
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int idUsuario) {
		id = idUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [id= "+id+", Nome= "+nome+", Sobrenome= "+sobrenome+", Cpf= "+cpf+", Sexo= "+sexo+",Email= "
				+email+", Endereço= "+endereco+", Senha= "+senha+", Tipo de usuário= "+tipo+"]";
	}

}
