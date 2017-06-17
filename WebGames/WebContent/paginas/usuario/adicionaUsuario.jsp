<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adiciona Usuário</title>
</head>
<body>
<font color="#FFFAFA"> <hl> <c:if
			test="${ not empty usuarioLogado}">
	Usuário logado: ${usuarioLogado.email}
	<div style="text-align: right;">
		<p>
				<a href="/WebGames/login?acao=Deslogar">Deslogar</a>
			</p>
</div>
			<hr>

		</c:if>
	<h1>---- Adiciona Usuário ----</h1>

	<hr /></font>
	
		<form action="/WebGames/usuario" method="POST">
			<input type="hidden" name="acao" value="Inserir" />
			<ul>
				<li>Nome:<br /> <input type="text" name="nome" />
				</li>
				<li>Sobrenome:<br /> <input type="text" name="sobrenome" />
				</li>
				<li>Sexo:</li>
				<input type="radio" name="sexo" value="m"> Masculino
				<hl> <input type="radio" name="sexo" value="f">
				Feminino<hl>
				<li>CPF:<br /> <input type="number" min="00000000000"
					max="99999999999" name="cpf" /></li>

				<li>Endereço:<br /> <input type="text" name="endereco" />
				</li>
				<li>E-mail:<br /> <input type="text" name="email" />
				</li>
				<li>Senha:<br /> <input type="password" name="senha" />
				</li>

				<li>Tipo de Usuário:</li>
				<c:if
			test="${ not empty usuarioLogado}">
			<input type="radio" name="tipo" value="Administrador"> Administrador<hl>
				<input type="radio" name="tipo" value="Funcionario"> Funcionário<hl>
			</c:if>
				<input type="radio" name="tipo" value="Cliente"> Cliente<hl>
			</ul>

			<input type="submit" value="Inserir" />
			<hr>
			<input type="reset" value="Limpar"> <br />
			<c:if
			test="${ usuarioLogado.tipo eq Cliente}">
			<center>
				<a href="Login.jsp">Fazer login</a><br>
			</center>
			</c:if>
			<c:if
			test="${ usuarioLogado.tipo eq Administrador}">
			<center>
				<a href="UsuarioEscolha.jsp">Menu Usuário</a><br>
			</center>
			</c:if>
		</form>
		
</body>
<style>
body {
	background-image: url(/WebGames/imagens/fundo.jpg);
	background-attachment: fixed;
	background-size: 100%;
	background-repeat: no-repeat;
	background-color: #000;
}
</style>
</html>