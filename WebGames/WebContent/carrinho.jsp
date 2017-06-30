<%@page import="br.com.upis.webgames.entidade.ItemDeCompra"%>
<%@page import="br.com.upis.webgames.entidade.Carrinho"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carrinho de Compras</title>
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

		</c:if></font>
	<h1>Carrinho de Compras!</h1>
	<table border="1" cellpadding="2">
		<tr>
			<td bgcolor="#000088"><font color="white">Excluir</font></td>
			<td bgcolor="#000088"><font color="white">Item</font></td>
			<td bgcolor="#000088"><font color="white">QTD</font></td>
			<td bgcolor="#000088"><font color="white">Preço Unitário</font></td>
			<td bgcolor="#000088"><font color="white">Total Item</font></td>
			<td bgcolor="#000088"><font color="white">+1</font></td>
		</tr>
		<%
			//recupera os produtos do carrinho da sessao
			Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
			for (ItemDeCompra item : carrinho.getItens()) {
		%>
		<tr>
			<td><a
				href="carrinho?acao=RemoveDoCarrinho&id=<%=item.getProduto().getId()%>">X</td>
			<td><%=item.getProduto().getNome()%></td>
			<td><%=item.getQuantidade()%></td>
			<td><%=item.getProduto().getPreco()%></td>
			<td><%=item.getTotal()%></td>
			<td><a
				href="carrinho?acao=AddNoCarrinho&id=<%=item.getProduto().getId()%>">+</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<strong>Valor Total: <%=carrinho.calculaTotal()%></strong>
	<br />
	<br>
	<br>
	<br>
	<a href="/WebGames/produto?escolha=Listar">Continuar comprando</a>
	<br />
	<br>
	<br>
	<a href="/WebGames/venda?acao=realizarVenda">Realizar pagamento</a>
	


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