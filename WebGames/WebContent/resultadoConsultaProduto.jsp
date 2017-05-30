<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da consulta</title>
</head>
<body>
<h1>Resultado da busca!!</h1>
<hr>
<br>
<br>
<table border="2">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Gênero</td>
				<td>Plataforma</td>
				<td>Descrição</td>
				<td>Preço</td>
				<td>Quantidade</td>
				<td>Opções</td>
				
			</tr>

			
				<tr>
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.genero}</td>
					<td>${produto.plataforma}</td>
					<td>${produto.descricao}</td>
					<td>${produto.preco}</td>
					<td>${produto.quantidade}</td>
	
					<td><a href="/WebGames/alteraProduto?escolha=opcaoAlterar&id=${produto.id}">Alterar</a><br>
					<a href="/WebGames/alteraProduto?escolha=Excluir&id=${produto.id}&nome=${produto.nome}">Excluir</a>
						</td>
				</tr>
		</table>
		<br>

	<a href="ProdutoEscolha.jsp">Menu Produto</a><br>

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