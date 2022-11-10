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
      font-size: 25px;
      
    }

    h1{
      text-align: center;
    }
    
    .container{
       width: 40%;
       margin-top: 35px;
    }
    
    /*Estilo do botão*/
    
    .largura{
    
       width: 50%;
    
    }
    
     #bt{
       margin-left: 25px;
       margin-top: 5px;
       font-size: 16px;
       float: left;
    
    }
    
    /*Estilo do link*/
    
    
  
    a:link{
       text-decoration : none;
       font-size: 20px;
       color: white;
       margin-left: 160px;
              
    }
    
    a:visited{
       text-decoration : none;
       color: white;
    
    }
    
    /*Formatação do formulário*/
    
    form{
       background-color: rgba(0, 0, 0, 0.6);
       border: 2px solid black;
       border-radius: 20px;
       
    
    }
    
    input[type=text]{
      width: 80%;
      margin: auto;
      
      
    }
    
    input[type=password]{
      width: 80%;
      margin: auto;
    }
    
    #sl{
    
      width: 80%;
      margin: auto;
      
    
    }
    
   
    

    </style>

    <title>Criar novo usuário</title>
</head>
<body>

 

<div class="container" >
    
        <form action="atualizarU" id="tLogin">
        <br>
          <h1>Alterar usuário</h1>
          <div class="form-group form-group-sm">
            
           <label for="usuario"></label>
            <input type="text" class="form-control"name="usuarios" value="<%out.print(request.getAttribute("usuarios"));%>">
          </div>
          <div class="form-group form-group-sm">
            <label for="senha"></label>
           <input type="text" class="form-control" name="senha" value="<%out.print(request.getAttribute("senha"));%>">
          </div>
          <br>
          <div class="input-group col-xs-10 form-group-sm" id="sl">
            
           <label for="funcao"></label>
            <select class="form-control" name="funcao">
               
               <option>Qual a função?</option>
               <option>Administrador</option>
               <option>Usuário</option>
            </select>
          </div><br>
          
           <div class="text-center">
          <button type="submit" class="btn btn-success btn-sm largura " onclick="validarUsuario()">Salvar</button>
          </div><br>
         
         
                 
          
        </form>
        
        
        <script src="scripts/validador.js"></script>
        </div>

</body>
</html>