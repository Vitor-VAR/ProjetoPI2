<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usu�rio Escolha</title>
</head>
<body>
	<center>
		<h1>******Op��es*****</h1>
		<br>
		<form action="/WebGames/UsuarioEscolha" method="get">
			<input type="hidden" name="escolha" value="opcaoInserir"> <input
				type="submit" value="Inserir Usu�rio">
		</form>
		<hr>
		<form action="/WebGames/UsuarioEscolha" method="get">
			<input type="hidden" name="escolha" value="Listar"> <input
				type="submit" value="Listar Usu�rio">
		</form>
		<hr>
		<form action="/WebGames/UsuarioEscolha" method="get">
			<input type="hidden" name="escolha" value="Consultar"> <input
				type="submit" value="Consultar Usu�rio">
		</form>
	</center>
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