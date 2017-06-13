<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>
	<font color="#FFFAFA"> <hl> <c:if
			test="${ not empty usuarioLogado}">
	Usuário logado: ${usuarioLogado.email}
	<form action="/WebGames/usuario" method="post">
				<input type="hidden" name="acao" value="Deslogar" />
				<div style="text-align: right;">
					<input type="submit" name="acao" value="Deslogar" />
				</div>
				<hr>
				<br> 
		</c:if>

		<div style="text-align: left;">

			<h1>** WEB GAMES **</h1>
		</div>
		<br>
		<h1>LOGIN USUÁRIO</h1>
		<hr />


		<form action="/WebGames/login" method="POST">
			<br /> <input type="hidden" name="acao" value="Logar" /> E-mail: <input
				type="text" name="email" />
			<hl> Senha: <input type="password" name="senha" /> <hl> <input
				type="submit" value="Logar" />
		</form>
		<h2>---CLIQUE NO LINK ABAIXO PARA FAZER O CADASTRO---</h2>
		<form action="/WebGames/login" method="POST">
			<br /> <input type="hidden" name="acao" value="Cadastrar" /> <input
				type="submit" value="Novo Usuário" />
		</form>
		<br />
		<%
			String nome = "Criador do site:(Vitor Almeida Ribeiro)";
		%> <%=nome%></font>
</body>
<style>
body {
	background-image: url(/WebGames/imagens/imgGames.jpg);
	background-attachment: fixed;
	background-size: 100%;
	background-repeat: no-repeat;
	background-color: #000;
}
</style>
</html>