<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Altera Produto</title>
</head>
<body>
	<h1>Altera Produto</h1>
	<hr />

	<P>Id do produto setado: ${prod.id}</P>
	<br>

	<ul>
		<form action="/WebGames/alteraProduto" method="post">
			<input type="hidden" name="acao" value="Alterar" /> <input
				type="hidden" name="id" value="${prod.id}" />
			<li>Jogo:<br /> <input type="text" name="${prod.nome}" />
			</li>
			<li>Gênero:<br /> <select name="genero">
					<option value="acao">Ação</option>
					<option value="aventura">Aventura</option>
					<option value="corrida">Corrida</option>
					<option value="esporte">Esporte</option>
					<option value="estrategia">Estratégia</option>
					<option value="luta">Luta</option>
					<option value="rpg">RPG</option>
					<option value="tiro">Tiro</option>
			</select>
			</li>
			<li>Plataforma:<br /> <select name="plataforma">
					<option value="pc">PC</option>
					<option value="ps4">PS4</option>
					<option value="ps3">PS3</option>
					<option value="xboxOne">XBOX ONE</option>
					<option value="xbox">XBOX</option>
					<option value="wiiU">WII U</option>
			</select>
			</li>

			<li>Descrição:<br /> <textarea name="descricao" rows="4"
					cols="50"> ${prod.descricao}</textarea>
			</li>
			<li>Preço:<br /> <input type="number" step="1.00" min="0"
				name="${prod.preco }" />
			</li>

			<li>Quantidade:<br /> <input type="number" name="quantidade"
				min="0" max="100" value="${prod.quantidade}" />
			</li>

			<li><label for="genero">Gênero:<br />
			</label></li>
			<c:choose>
				<c:when test="${prod.genero.toString() eq acao}">
					<input type="radio" name="genero" checked="checked" value="acao" />Ação <br />
					<input type="radio" name="genero" value="luta" />Luta<br />
				</c:when>
				<c:otherwise>
					<input type="radio" name="genero" value="acao" />Luta <br />
					<input type="radio" name="generoo" checked="checked" value="luto" />Ação<br />
				</c:otherwise>
			</c:choose>

			<input type="submit" value="Alterar" /> <input type="reset"
				value="Limpar">
		</form>
	</ul>
	<a href="ProdutoEscolha.jsp">Menu Produto</a>

</body>
</html>