<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Veiculo"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Veiculo> lista = (ArrayList<Veiculo>) request.getAttribute("tb_veiculo");
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
<title>Dados dos Veículos</title>
<style>
body {
	font-size: 16px;
	display: inline;
	text-align: center;
	background-image:
		url(https://thumbs.dreamstime.com/b/fundo-preto-da-parede-de-tijolo-119596329.jpg);
	color: white;
}


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
 #bt1{
     margin-left: 15px;
       margin-top: 5px;
       float: right;
       font-size: 16px;
 
 
 }  

#pesc{
   margin-left: 150px;
 
 }


</style>
<style>
</style>

</head>
<body>

	<a href="Principal.html"><button type="button" id="bt"
			class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-hand-left">HOME</span>
		</button></a>
		
		<a href="documentoV"><button type="button" id="bt1" class="btn btn-default btn-sm">
        <span class="glyphicon glyphicon-list-alt">RELATÓRIO</span></button></a>

	<h1>Dados dos Veículos</h1>
	
	 <form id="pesc">
	 <div class="input-group col-xs-10 form-group-sm">
	    <span class="input-group-addon"><b>Pesquisar:</b></span> 
	    <input type="text" id="buscarV"  class="form-control">
	    </div>
	    <br>

	 </form>
	


	<table id="tabelaV" class="table">
		<thead>
			<tr>
				<th>NUMERO DA PLACA</th>
				<th>MARCA</th>
				<th>MODELO</th>
				<th>TIPO DE VEÍCULO</th>
				<th>CPF</th>
				<th>Opções</th>

			</tr>
		</thead>

		<tbody>

			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getNumeroPlaca()%></td>
				<td><%=lista.get(i).getMarca()%></td>
				<td><%=lista.get(i).getModelo()%></td>
				<td><%=lista.get(i).getTipoVeiculo()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><a
					href="editarV?numeroPlaca=<%=lista.get(i).getNumeroPlaca()%>"><button
							type="button" class="btn btn-success">Editar</button></a> <a
					href="javascript: confirmador('<%=lista.get(i).getNumeroPlaca()%>')"><button
							type="button" class="btn btn-danger">Excluir</button></a>
			</tr>


			<%
			}
			%>


		</tbody>



	</table>

	<script src="scripts/confirmar.js"></script>
	<script src="scripts/listaV.js"></script>
	


</body>
</html>