<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Pagar"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Pagar> lista = (ArrayList<Pagar>) request.getAttribute("tb_finalizarservico");


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
<title>Dados dos Clientes</title>
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
 #bt{
       margin-left: 15px;
       margin-top: 5px;
       float: left;
       font-size: 16px;
    
    }
    
 
 
 #busca{
    margin-left: 100px;
 
 }
 

 
</style>

</head>
<body>
   
   <a href="Principal.html"><button type="button" id="bt" class="btn btn-default btn-sm">
           <span class="glyphicon glyphicon-hand-left">HOME</span>
        </button></a>
        
         

	<h1>Clientes á Pagar</h1>
	
	 <form id="busca">
	 <div class="input-group col-xs-10 form-group-sm">
	    <span class="input-group-addon"><b>Pesquisar:</b></span> 
	    <input type="text" id="buscarPg"  class="form-control">
	    </div>
	    <br>

	 </form>
	 
	

	<div >
		<table id="tabela" class="table">
			<thead>
				<tr>
					<th>CPF</th>
					<th>PERIODO</th>
					<th>DATA</th>
					<th>VALOR</th>
					
					
				</tr>
			</thead>

			<tbody>

				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getCpf()%></td>
					<td><%=lista.get(i).getPeriodo()%></td>
					<td><%=lista.get(i).getData()%></td>
					<td><%=lista.get(i).getValor()%></td>
					<td><a href="documentoP?cpf<%=lista.get(i).getCpf()%>"><button 
					type="button" class="btn btn-success">Gerar NFE</button></a></td>
					
				</tr>


				<%
				}
				%>


			</tbody>



		</table>

	</div>

	 <script src="scripts/listaP.js"></script>

</body>
</html>