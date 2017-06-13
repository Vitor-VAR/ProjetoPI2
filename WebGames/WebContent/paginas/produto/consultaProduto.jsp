<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Produto</title>
</head>
<body><font color="#FFFAFA"> <hl> <c:if
			test="${ not empty usuarioLogado}">
	Usuário logado: ${usuarioLogado.email}
	<form action="/WebGames/login" method="post">
				<div style="text-align: right;">
					<input type="submit" name="acao" value="Deslogar" />
				</div>
				<hr>
				<br>
		</c:if>
	

<form action="/WebGames/produto" method="POST">
	<input type="hidden" name="acao" value="Consultar" />
	<ul>
		Informe o ID do Produto:<br /> <input type="number" name="id" min="1"/>
		<br />
		<input type="submit" value="Consultar" />
	
		<input type="reset" value="Limpar">
		<br />
	</ul>
</form>
<br>
<br>
<br>
<a href="ProdutoEscolha.jsp">Menu Produto</a><br></font>

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