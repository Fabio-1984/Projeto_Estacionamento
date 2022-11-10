<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("tb_usuario");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Usuários cadastrados</title>
<style>
body {
	font-size: 16px;
	display: inline;
	text-align: center;
	background-image:
		url(https://thumbs.dreamstime.com/b/fundo-preto-da-parede-de-tijolo-119596329.jpg);
	color: white;
}

/*table {
	border-collapse: collapse;
	width: 100%;
	background-color: white;
	color: black;
}


tr:nth-child(even) {
	background-color: #cbffb3;
}

th {
	background-color: #00b300;
	color: white;
	padding: 10px;
}*/

th, td {
	text-align: center;
	padding: 8px;
	background-color: black;
	color: white;
}

#bt {
	margin-left: 15px;
	margin-top: 5px;
	float: left;
	font-size: 16px;
}
</style>
</head>
<body>


	<a href="Principal.html"><button type="button" id="bt"
			class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-hand-left">HOME</span>
		</button></a>

	<h1>Dados dos usuarios</h1>


	<table id="tabela" class="table">
		<thead>
			<tr>
				<th>USUARIO</th>
				<th>SENHA</th>
				<th>FUNCAO</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>

			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getUsuario()%></td>
				<td><%=lista.get(i).getSenha()%></td>
				<td><%=lista.get(i).getFuncao()%></td>


				<td><a href="editarU?usuarios=<%=lista.get(i).getUsuario()%>"><button
							type="button" class="btn btn-success">Editar</button></a> <a
					href="javascript: confirmadorUm('<%=lista.get(i).getUsuario()%>')"><button
							type="button" class="btn btn-danger">Excluir</button></a></td>


				<!-- ? = Significa que vai encaminhar ao documento algum parâmetro-->
				<!-- <lista.get(i).getCpf() % Encaminha o numero do ID ao contato que quero editar-->
			</tr>


			<%
			}
			%>


		</tbody>



	</table>

	<script src="scripts/confirmar.js"></script>

</body>
</html>