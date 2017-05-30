<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<h1>Adiciona Usuário</h1>
	<hr />

	<form action="/WebGames/adicionaUsuario" method="POST">
		<input type="hidden" name="acao" value="Inserir" />
		<ul>
			<li>Nome:<br /> <input type="text" name="nome" />
			</li>
			<li>Sobrenome:<br /> <input type="text" name="sobrenome" />
			</li>
			<li>Sexo:</li>
			<input type="radio" name="sexo" value="m"> Masculino
			<hl> <input type="radio" name="sexo" value="f"> Feminino<hl>
			<li>CPF:<br /> <input type="text" name="cpf" /></li>

			<li>Endereço:<br /> <input type="text" name="endereco" />
			</li>
			<li>E-mail:<br /> <input type="text" name="email" />
			</li>
			<li>Senha:<br /> <input type="password" name="senha" />
			</li>

			<li>Tipo de Usuario:</li>

			<input type="radio" name="tipo" value="f"> Funcionário<hl>

			<input type="radio" name="tipo" value="c"> Cliente<hl>
		</ul>

		<input type="submit" value="Inserir" />
		<hr>
		<input type="reset" value="Limpar"> <br />
		<center>
			<a href="Login.jsp">Fazer login:</a><br>
		</center>
	</form>

</body>
</html>