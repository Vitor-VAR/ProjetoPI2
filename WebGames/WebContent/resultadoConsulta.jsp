<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da consulta</title>
</head>
<body>
<h1>Resultado da busca!!</h1>
<hr>
<table border="1">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Sobrenome</td>
				<td>CPF</td>
				<td>Sexo</td>
				<td>E-mail</td>
				<td>Endere�o</td>
				<td>Senha</td>
				<td>Tipo</td>
				<td>Comandos</td>
			</tr>

			
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.sobrenome}</td>
					<td>${usuario.cpf}</td>
					<td>${usuario.sexo}</td>
					<td>${usuario.email}</td>
					<td>${usuario.endereco}</td>
					<td>${usuario.senha}</td>
					<td>${usuario.tipo}</td>
					<td><a href="/WebGames/alteraUsuario?escolha=opcaoAlterar&id=${usuario.id}">Alterar</a>
					<a href="/WebGames/alteraUsuario?escolha=Excluir&id=${usuario.id}&nome=${usuario.nome}">Excluir</a>
						</td>
				</tr>
		</table>
		<br>

	<a href="UsuarioEscolha.jsp">Menu Usu�rio</a><br>
</body>
		<style>
body {
	background-image: url(fundo.jpg);
	background-attachment: fixed;
	background-size: 100%;
	background-repeat: no-repeat;
	background-color: #000;
}
</style>
</html>