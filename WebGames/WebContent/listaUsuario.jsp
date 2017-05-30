<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
	<style>
body {
	background-image: url(fundo.jpg);
	background-attachment: fixed;
	background-size: 100%;
	background-repeat: no-repeat;
	background-color: #000;
}
</style>
	<h1>Lista de Usuários</h1>
	<hr />
	<div align="center">
	<p>LISTA DE USUÁRIOS</p>

		<table border="1">
			<tr>
				<td>ID</td>
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
					<td><c:out value= "${usuario.id}"/></td>
					<td>${usuario.nome}</td>
					<td>${usuario.sobrenome}</td>
					<td>${usuario.cpf}</td>
					<td>${usuario.sexo}</td>
					<td>${usuario.email}</td>
					<td>${usuario.endereco}</td>
					<td>${usuario.tipo}</td>
					<td><a href="/WebGames/alteraUsuario?escolha=opcaoAlterar&id=${usuario.id}">Alterar</a>
					
					<a href="/WebGames/alteraUsuario?escolha=Excluir&id=${usuario.id}&nome=${usuario.nome}">Excluir</a>
						</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(usuarioLista) > 0}">
   		Existem ${fn:length(usuarioLista)} Usuários!
 		</c:if>
		<br>
	</div>
	<h2>Usuário excluído com sucesso: ${nome}</h2>

	<a href="UsuarioEscolha.jsp">Voltar</a>
</body>
</html>