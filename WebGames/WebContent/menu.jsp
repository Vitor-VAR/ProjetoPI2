<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<font color="#FFFAFA">
<hl> <c:if test="${ not empty usuarioLogado}">
	Usuário logado: ${usuarioLogado.email}
	<form action="/WebGames/usuario" method="post">
		<input type="hidden" name="acao" value="Deslogar" />
		<p>
			<input type="submit" name="acao" value="Deslogar"
				style="margin: -35px 0px 0px 90%" />
		</p>

		<hr>
	
	</c:if>
	<center>
	<h1>---- Menu ----</h1>
	<hr />
	<br>
	<br>
	<br>

		<p>
			<a href="paginas/usuario/UsuarioEscolha.jsp">Crud Usuário</a><br>
			<br> <br>
		<p>
			<a href="paginas/produto/ProdutoEscolha.jsp">Crud Produto</a><br>
			<br> <br>
		<p>
			<a href="paginas/relatorios/relatorioLucro.jsp">Relatórios</a><br></center></font>
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