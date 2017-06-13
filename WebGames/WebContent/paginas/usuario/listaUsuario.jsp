<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
<font color="#FFFAFA">
	<hl> <c:if
			test="${ not empty usuarioLogado}">
	Usuário logado: ${usuarioLogado.email}
	<form action="/WebGames/login" method="post">
				<div style="text-align: right;">
					<input type="submit" name="acao" value="Deslogar" />
				</div>
				<hr>
				<br> 
		</c:if>

	<h1>Lista de Usuários</h1>
	<hr />
	</font>
	
		<div align="center">
			<p>LISTA DE USUÁRIOS</p>

			<table border="2">
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
						<td><c:out value="${usuario.id}" /></td>
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
							href="/WebGames/usuario?escolha=Excluir&id=${usuario.id}&nome=${usuario.nome}&infoPagina=listar">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${fn:length(usuarioLista) > 0}">
   		Existem ${fn:length(usuarioLista)} Usuários!
 		</c:if>
			<br>
		</div>
		<p>${nome}</p>

		<a href="paginas/usuario/UsuarioEscolha.jsp">Voltar</a>
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