<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da consulta</title>
</head>
<body>
<font color="#FFFAFA">
<c:if
			test="${ not empty usuarioLogado}">
	Usuário logado: ${usuarioLogado.email}
	<div style="text-align: right;">
		<p>
				<a href="/WebGames/login?acao=Deslogar">Deslogar</a>
			</p>
</div>
			<hr>

		</c:if>
	<h1>Resultado da busca!!</h1>
	<hr>
	<br>
	<br>
	<br>
	</font>
	
	<table border="2">
		<tr>

			<td>Nome</td>
			<td>Sobrenome</td>
			<td>CPF</td>
			<td>Sexo</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Tipo</td>
			<td>Comandos</td>
		</tr>


		<c:forEach var="usuario" items="${usuarioLista}">
			<tr>
				<td>${usuario.nome}</td>
				<td>${usuario.sobrenome}</td>
				<td>${usuario.cpf}</td>
				<td>${usuario.sexo}</td>
				<td>${usuario.email}</td>
				<td>${usuario.endereco}</td>
				<td>${usuario.tipo}</td>
				<td><a
					href="/WebGames/usuario?escolha=opcaoAlterar&id=${usuario.id}">Alterar</a>

					<a
					href="/WebGames/usuario?escolha=Excluir&id=${usuario.id}&nome=${usuario.nome}&infoPagina=Consultar">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${fn:length(usuarioLista) > 0}">
   		Existem ${fn:length(usuarioLista)} Usuários!
 		</c:if> <br>

	
	<p>${nome}</p>
	<br>
	<br>
	<br>
	<br>
	<center>
		<a href="paginas/usuario/UsuarioEscolha.jsp">Menu Usuário</a><br>
	</center>
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