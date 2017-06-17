<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Produto</title>
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
	
		<center>
			<h1>**** MENU PRODUTOS ****</h1>
			<hr />
			<br> <br>
			<form action="/WebGames/produto" method="get">
				<input type="hidden" name="escolha" value="Inserir"> <input
					type="submit" value="Inserir">
			</form>
			<hr>
			<br> <br>
			<form action="/WebGames/produto" method="get">
				<input type="hidden" name="escolha" value="Listar"> <input
					type="submit" value="Listar">
			</form>
			<hr>
			<br> <br>
			<form action="/WebGames/produto" method="get">
				<input type="hidden" name="escolha" value="Consultar"> <input
					type="submit" value="Consultar">
			</form>
		</center>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<a href="/WebGames/menu.jsp">Menu Principal</a></font>

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