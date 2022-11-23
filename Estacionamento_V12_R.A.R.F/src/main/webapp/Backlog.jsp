<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Suporte"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Suporte> lista = (ArrayList<Suporte>) request.getAttribute("tb_suporte");

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
<title>DFila de chamados</title>
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
        
      

	<h1>Chamados na fila</h1>
	
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
					<th>Nº DO CHAMADO</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>DESCRIÇÃO</th>
					<th>ANEXOS</th>
					
					<th>Opções</th>
				</tr>
			</thead>

			<tbody>

				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getChamado()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><%=lista.get(i).getDescricao()%></td>
					<td><%=lista.get(i).getArquivo()%></td>
					
					<td><a href="editarS?nome=<%=lista.get(i).getNome()%>"><button
								type="button" class="btn btn-success">Assumir</button></a> 
						
								
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

	
	<script src="scripts/listaS.js"></script>

</body>
</html>