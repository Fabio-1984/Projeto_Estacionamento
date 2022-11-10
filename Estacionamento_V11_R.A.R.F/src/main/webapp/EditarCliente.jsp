<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
    <style>
      body{
      background-image: url(https://thumbs.dreamstime.com/b/fundo-preto-da-parede-de-tijolo-119596329.jpg);
      color:white;
      font-size: 20px;
      display: inline;
               
    }
    
    
    /*Direcionamento do formulário*/
  
    .container{
      max-width: 700px;   
      margin-left: 350px;
      margin-top: 10px;
      background-color: rgba(0, 0, 0, 0.6);
      
    }
    
    form{
       margin-left: 80px;  
       
    }
    
    
    /* Formatação do Inputs*/
       
    button[type=button]{
    
         margin-left: 200px;
         margin-bottom: 15px;
        
    }
    
    #bt{
       margin-left: 15px;
       margin-top: 5px;
       float: left;
       font-size: 16px;
    
    }
    

    input{
      color: black;
    }

    select{
      color: black;
      padding: 2px;
    }
    
    
    
    
    /*Formatação do link*/
    
     a:link{
       text-decoration : none;
       font-size: 20px;          
    }
     
    a:visited{
       text-decoration : none;
       color: black;
    
    }

    </style>

    <title> Editar Cliente</title>
</head>
<body> 
 



   <div class="container">
    <form id="cadCli" action="atualizarC">
        <h1 style="margin-left: 150px"> Editar Cliente </h1>
        
         <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"><b>CPF:</b></span>
          <input type="text" class="form-control" name="cpf" readonly value="<%out.print(request.getAttribute("cpf"));%>">
		    <!---<b><input type="submit" value="Verificar"></b>--->
        </div>
        <br>
    

        <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"><b>Nome:</b></span>
          <input  type="text" class="form-control" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
        </div>
        <br>
        
           <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"> <b>E-mail:</b> <i class="glyphicon glyphicon-user"></i></span>
          <input type="email" class="form-control" name="email" value="<%out.print(request.getAttribute("email"));%>">
        </div>
        <br>
        
           
        <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"><b>Habilitação</b></span>
          <input type="text" class="form-control" name="habilitacao" value="<%out.print(request.getAttribute("habilitacao"));%>">
        </div>
        <br>
         
        <br>
        <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"><b>Data de Nascimento:</b></span>
          <input type="text" class="form-control" name="dataNascimento" value="<%out.print(request.getAttribute("dataNascimento"));%>">
        </div>
        <br>
        <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"><b>Celular / Telefone:</b></span>
          <input type="tel" class="form-control" name="telefone" value="<%out.print(request.getAttribute("telefone"));%>">
        </div>
        <br>
        <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"> <b>Tipo De Cliente</b> <i class="glyphicon glyphicon-user"></i></span>
            <select  name="tipoCliente">
            <option value="Mensal"></option> 
              <option value="Mensal">Mensal</option> 
              <option value="Avulso">Avulso</option> 
            </select>
          </div>
          <br>
          
         <!-- <p>Atrelar veículo ao cadastro do usuário<a href="Cadastro_Veiculo.html"> <b>Clique aqui! </b></a></p> -->
          
          <button type="button" class="btn btn-success btn-lg col-xs-3" onclick="validarAlteracaoC()"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><b> Salvar</b></font></font></button>
          
         
      </form>
      
      <script src="scripts/validador.js"></script>
      <br>
      </div>
    
</body>
</html>