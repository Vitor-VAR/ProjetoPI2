<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adiciona Produto</title>
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

		<h1>Adiciona Produto</h1>
		<hr /></font>
		<form action="/WebGames/produto" method="POST">
			<input type="hidden" name="acao" value="Inserir" />
			<ul>
				<li>Jogo:<br /> <input type="text" name="nome" />
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
						cols="50"> </textarea>
				</li>

				<li>Preço:<br /> <input type="number" step="1.00" min="0"
					name="valor" />
				</li>
				<li>Quantidade:<br /> <input type="number" min="0" max="500"
					name="quantidade" />
				</li>


			</ul>

			<input type="submit" value="Inserir" />
			<hl> <input type="reset" value="Limpar"> <br />
			<center>
				<a href="ProdutoEscolha.jsp">Menu Produto</a><br>
			</center>
		</form>
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