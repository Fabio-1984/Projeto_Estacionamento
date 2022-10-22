<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Cliente> lista = (ArrayList<Cliente>)request.getAttribute("tb_cliente");
for (int i = 0; i < lista.size(); i++) {

	out.println(lista.get(i).getCpf());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getEmail());
	out.println(lista.get(i).getHabilitacao());
	out.println(lista.get(i).getPlaca());
	out.println(lista.get(i).getNascimento());
	out.println(lista.get(i).getTelefone());
	out.println(lista.get(i).getTipo_de_cliente());
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <!-- 
	<h1>Dados dos usuários</h1>
	<form name="frmCliente" action="">

		<table>
			<tr>
				<td><input type="text" name="cpf" placeholder="CPF"></td>
			</tr>

			<tr>
				<td><input type="text" name="nome" placeholder="Nome"></td>
			</tr>

			<tr>
				<td><input type="text" name="email" placeholder="Email"></td>
			</tr>

			<tr>
				<td><input type="text" name="habilitacao"
					placeholder="xxxxxxxxx-xxx"></td>
			</tr>

			<tr>
				<td><input type="text" name="placa" placeholder="Digite a plca"></td>
			</tr>

			<tr>
				<td><input type="text" name="dataNascimento" placeholder="Data de Nascimento formato xx/xx/xxxx"></td>
			</tr>

			<tr>
				<td><input type="text" name="telefone" placeholder="(xx)9xxxx-xxxx - (xx)xxxx-xxxx"></td>
			</tr>

			<tr>
				<td><input type="text" name="tipoCliente" placeholder="Tipo de cliente"></td>
			</tr>





		</table>


          <input type="button" value="Verificar" >

	</form>
	 -->
  

</body>
</html>