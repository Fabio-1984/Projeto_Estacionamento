/**
 * Confirmar a exclusão de um contato
 * @authors Antonio, Fabio e Rafael
 */
 
 
 
 function confirma(cpf){
     let resposta = confirm("Tem certeza que deseaja excluir esse contato ?")
     
     if (resposta === true){
        // alert(cpf)
         
         window.location.href = "deleteC?cpf=" + cpf
         
     
     }
 
 }
 
 
 function confirmador(numeroPlaca){
     let resposta = confirm("Tem certeza que deseaja excluir esse veículo ?")
     
     if (resposta === true){
        alert(numeroPlaca)
         
         window.location.href = "deleteV?numeroPlaca=" + numeroPlaca
         
     
     }
 
 }
 
 
 function confirmadorUm(usuarios){
     let resposta = confirm("Tem certeza que deseaja excluir esse usuário?")
     
     if (resposta === true){
        alert(usuarios)
         
         window.location.href = "deleteU?usuarios=" + usuarios
         
     
     }
 
 }
 
 
 
  function confirmaTk(){
      
        alert('Ticket Nº XXXXXX gerado')
         
       
     
     }
 
