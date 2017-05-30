<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="usuario" class="br.com.upis.webgames.entidade.Usuario" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar</title>
</head>
<body>
	<h1>Altera Usuário</h1>
	<hr />
	<P>Id do usuário setado: ${usu.id}</P>
	
	
	<ul>
		<form action="/WebGames/alteraUsuario" method="post">
			<input type="hidden" name="acao" value="Alterar" /> 
			<input type="hidden" name="id" value="${usu.id}"/> 
			<li><label for="nome">Nome:<br /> </label> <input type="text"
				name="nome" id="nome" value="${usu.nome}"/></li>
			<li><label for="sobrenome">Sobrenome: <br /></label><input type="text"
				name="sobrenome" id="sobrenome" value="${usu.sobrenome}"/></li>
			<li><label for="email">Email:<br /> </label><input type="text"
				name="email" id="email" value="${usu.email}"/></li>
			<li><label for="cpf">CPF:<br /></label> <input type="text" name="cpf"
				id="cpf" value="${usu.cpf}" /></li>
			<li><label for="senha">Senha:<br /> </label><input type="text"
				name="senha" id="senha" value="${usu.senha}"/></li>
			<li><label for="endereco">Endereço: <br /></label><input type="text"
				name="endereco" id="endereco" value="${usu.endereco}" /></li>
			<li><label for="sexo">Sexo:<br /> </label></li>
			<c:set var="m" value="M" />
			<c:choose>
				<c:when test="${usu.sexo.toString() eq m}">
					<input type="radio" name="sexo" checked="checked" value="M" />Masculino <br />
					<input type="radio" name="sexo" value="F" />Feminino<br />
				</c:when>
				<c:otherwise>
					<input type="radio" name="sexo" value="M" />Masculino <br />
					<input type="radio" name="sexo" checked="checked" value="F" />Feminino<br />
				</c:otherwise>
			</c:choose>
			<li>Tipo de Usuario:</li>

			<input type="radio" name="tipo" value="f"> Funcionário<hl>

			<input type="radio" name="tipo" value="c"> Cliente<hl>

			<p>
				<input type="submit" value="Alterar" /> <input type="reset"
					value="Limpar">
		</form>
	</ul>
	<a href="UsuarioEscolha.jsp">Voltar</a>

</body>
</html>