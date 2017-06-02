<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>
</head>
<body>
		
	<h1>Lista Produto</h1>
	<hr />
	<div align="center">
	<p>LISTA DE PRODUTOS</p>

		<table border="1">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>G�nero</td>
				<td>Plataforma</td>
				<td>Descri��o</td>
				<td>Valor</td>
				<td>Quantidade</td>
				<td>Op��es</td>
				
			</tr>

			<c:forEach var="produto" items="${produtoLista}">
				<tr>
					<td><c:out value= "${produto.id}"/></td>
					<td>${produto.nome}</td>
					<td>${produto.genero}</td>
					<td>${produto.plataforma}</td>
					<td>${produto.descricao}</td>
					<td>${produto.preco}</td>
					<td>${produto.quantidade}</td>
					
					
					<td><a href="/WebGames/alteraProduto?escolha=opcaoAlterar&id=${produto.id}">Alterar</a>
					
					<a href="/WebGames/alteraProduto?escolha=Excluir&id=${produto.id}&nome=${produto.nome}&infoPagina=listar">Excluir</a>
						</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(produtoLista) > 0}">
   		Existem ${fn:length(produtoLista)} Produtos!
 		</c:if>
		<br>
	</div>
	<h2> ${nome}</h2>

	<a href="paginas/produto/ProdutoEscolha.jsp">Voltar</a>
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