<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MesangemInsert</title>
</head>
<body><font color="#FFFAFA">
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

	<h2>Usuário inserido com sucesso: ${usuario.nome}</h2>

<c:if test="${not empty usuarioLogado}">
		<a href="paginas/usuario/UsuarioEscolha.jsp">Menu Usuário</a>
		<br>
		<br>
		<br>
		<a href="paginas/usuario/adicionaUsuario.jsp">Inserir mais usuários</a>
		<br>
	</c:if>
	<c:if test="${empty usuarioLogado}">
	<center>
		<a href="paginas/usuario/Login.jsp">Fazer login</a><br>
	</center>
	</c:if>
	</font>
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