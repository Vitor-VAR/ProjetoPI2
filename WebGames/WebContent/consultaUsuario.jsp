<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Usuário</title>
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

<form action="/WebGames/consultaUsuario" method="POST">
	<input type="hidden" name="acao" value="Consultar" />
	<ul>
		Informe o ID do Usuário:<br /> <input type="text" name="id" />
		<br />
		<input type="submit" value="Consultar" />
	
		<input type="reset" value="Limpar">
		<br />
	</ul>
</form>

<a href="UsuarioEscolha.jsp">Voltar</a>



</body>
</html>