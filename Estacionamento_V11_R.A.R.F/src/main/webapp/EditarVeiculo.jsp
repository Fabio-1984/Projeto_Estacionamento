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
    }
    
      /*Direcionamento do formulário*/
  
    .container{
      
      width: 60%;
      margin-left: 350px;
      margin-top: 30px;
      background-color: rgba(0, 0, 0, 0.6);
   
    
    }
    
    
    /* Formatação do Inputs*/
    
    form{
       margin-left: 80px;
    }
       
    button[type=button]{
  
         margin-left: 200px;
         margin-bottom: 15px;
        
    }
    
    #bt{
       margin-left: 25px;
       margin-top: 5px;
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

    <title> Cadastre-se </title>
</head>
<body>
 
    
     
     <div class="container">
     
     
    <form action="atualizarv" id="cadVei">
      <h1 style="margin-left: 150px"> Cadastro de veículo </h1>
      
        <div class="input-group col-xs-10">
          <span class="input-group-addon"><b>Nº da Placa:</b></span>
          <input type="text" class="form-control" name="numeroPlaca" readonly value="<%out.print(request.getAttribute("numeroPlaca"));%>">
        </div>
        <br>
      
        <div class="input-group col-xs-10">
          <span class="input-group-addon"><b>Marca:</b></span>
          <input id="marca" type="text" class="form-control" name="marca" value="<%out.print(request.getAttribute("marca"));%>">
        </div>
        <br>
        <div class="input-group col-xs-10">
          <span class="input-group-addon"><b>Modelo:</b></span>
          <input id="modelo" type="text" class="form-control" name="modelo" value="<%out.print(request.getAttribute("modelo"));%>">
        </div>
        <br>
              
        <div class="input-group col-xs-10 form-group-sm">
          <span class="input-group-addon"> <b>Tipo de Veículo</b> <i class="glyphicon glyphicon-user"></i></span>
            <select id="tipoVeiculo" name="tipoVeiculo" >
            <option value=""></option> 
              <option value="Carro">Carro</option> 
              <option value="Moto">Moto</option>
              <option value="Van">Van</option>  
            </select>
          </div>
          <br>
          
          <div class="input-group col-xs-10">
          <span class="input-group-addon"><b>CPF:</b></span>
          <input id="cpf" type="text" class="form-control" name="cpf" readonly value="<%out.print(request.getAttribute("cpf"));%>">
        </div>
        <br>
        
          <button type="button" class="btn btn-success btn-lg col-xs-3" onclick="validarAlteracaoV()"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><b> Salvar </b></font></font></button>
      </form>
        <script src="scripts/validador.js"></script>
      <br>
      
      </div>
    
</body>
</html>