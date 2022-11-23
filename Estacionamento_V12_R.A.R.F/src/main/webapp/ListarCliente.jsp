<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("tb_cliente");

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
    
    
 #bt1{
     margin-right: 15px;
       margin-top: 5px;
       float: right;
       font-size: 16px;
 
 
 }   
 
  #bt2{
       margin-right: 20px;
       margin-top: 5px;
       float: right;
       font-size: 16px;
 
 
 } 
 

  
 
</style>

</head>
<body>
   
   <a href="Principal.html"><button type="button" id="bt" class="btn btn-default btn-sm">
           <span class="glyphicon glyphicon-hand-left"> HOME</span>
        </button></a>
        
        <a href="documento"><button type="button" id="bt1" class="btn btn-default btn-sm">
        <span class="glyphicon glyphicon-picture"> RELATÓRIO</span></button></a>
        
         
         <a href="Cadastrar_Cliente.html"> <button type="button" id="bt2" class="btn btn-default btn-sm">
           <span class="glyphicon glyphicon-list-alt"> CADASTRAR</span>
        </button></a><br>

	<h1>Dados dos clientes</h1>
	
	 <form id="pesc">
	 <div class="input-group col-xs-5 form-group-sm">
	    <span class="input-group-addon"><b>Pesquisar:</b></span> 
	    <input type="text" id="buscarC"  class="form-control">
	    </div>
	    <br>
	    
	   
	   	    

	 </form>
	  
	
	

	<div >
		<table id="tabela" class="table">
			<thead>
				<tr>
					<th>CPF</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>HABILITAÇÃO</th>
					<th>NASCIMENTO</th>
					<th>TELEFONE</th>
					<th>TIPO DE CLIENTE</th>
					<th>Opções</th>
				</tr>
			</thead>

			<tbody>

				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getCpf()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><%=lista.get(i).getHabilitacao()%></td>
					<td><%=lista.get(i).getNascimento()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getTipo_de_cliente()%></td>
					<td><a href="editarC?cpf=<%=lista.get(i).getCpf()%>"><button
								type="button" class="btn btn-success">Editar</button></a> <a
						href="javascript: confirma('<%=lista.get(i).getCpf()%>')"><button
								type="button" class="btn btn-danger">Excluir</button></a>
						<a href="javascript: confirmaTk()"><button
								type="button" class="btn btn-info">Gerar Ticket</button></a>		
   					</td>
					<!-- ? = Significa que vai encaminhar ao documento algum parâmetro-->
					<!-- <lista.get(i).getCpf() % Encaminha o numero do ID ao contato que quero editar-->
				</tr>


				<%
				}
				%>


			</tbody>



		</table>

	</div>

	<script src="scripts/confirmar.js"></script>
	<script src="scripts/listaC.js"></script>

</body>
</html>