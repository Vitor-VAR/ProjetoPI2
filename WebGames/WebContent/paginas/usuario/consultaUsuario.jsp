<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Usu�rio</title>
</head>
<body>
	<font color="#FFFAFA"> <hl> <c:if
			test="${ not empty usuarioLogado}">
	Usu�rio logado: ${usuarioLogado.email}
	<form action="/WebGames/login" method="post">
				<div style="text-align: right;">
					<input type="submit" name="acao" value="Deslogar" />
				</div>
				<hr>
				<br>
		</c:if>


		<form action="/WebGames/usuario" method="POST">
			<input type="hidden" name="acao" value="Consultar" />
			<ul>
				Informe o ID do Usu�rio:
				<br />
				<input type="text" name="id" />
				<br />
				<input type="submit" value="Consultar" />

				<input type="reset" value="Limpar">
				<br />
			</ul>
		</form>

		<a href="UsuarioEscolha.jsp">Voltar</a></font>
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