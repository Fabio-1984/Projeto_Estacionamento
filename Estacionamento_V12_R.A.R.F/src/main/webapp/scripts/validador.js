/**
 * Validação de formulários
 * @autor Fabio, Rafael e Antonio
 */
 


/*Validar tela de login*/




/*Validação do formulário cadastro de cliente*/

function validarCliente(){
 
   let cpf = cadCli.cpf.value
   let nome = cadCli.nome.value
   let email = cadCli.email.value
   let habilitacao = cadCli.habilitacao.value
   let nascimento = cadCli.dataNascimento.value
   let telefone = cadCli.telefone.value
   let tipoCliente = cadCli.tipoCliente.value
   
   if (cpf === ""){
     alert('Preencha o campo cpf')
     cadCli.cpf.focus()
     return false
     
   }else if (nome === ""){
   
     alert('Preencha o campo nome')
     cadCli.nome.focus()
     return false
   
   }else if (email === ""){
   
     alert('Preencha o campo email')
     cadCli.email.focus()
     return false
   
   }else if (habilitacao === ""){
   
     alert('Preencha o campo habilitacao')
     cadCli.habilitacao.focus()
     return false
   
   }else if (nascimento === ""){
   
     alert('Preencha o campo data de nascimento')
     cadCli.nascimento.focus()
     return false
   
   }else if (telefone === ""){
   
     alert('Preencha o campo telefone')
     cadCli.htelefone.focus()
     return false
   
   }else if (tipoCliente === ""){
   
     alert('Selecione um tipo de cliente')
     cadCli.tipoCliente.focus()
     return false
   
   }else {
       
       document.forms["cadCli"].submit()
       
   }
 
 }
 
 /*Validação do formulário alteracao de cliente*/
 
 function validarAlteracaoC(){
 
  
   let nome = cadCli.nome.value
   let email = cadCli.email.value
   let habilitacao = cadCli.habilitacao.value
   let nascimento = cadCli.dataNascimento.value
   let telefone = cadCli.telefone.value
   let tipoCliente = cadCli.tipoCliente.value
   
   if (nome === ""){
   
     alert('Preencha o campo nome')
     cadCli.nome.focus()
     return false
   
   }else if (email === ""){
   
     alert('Preencha o campo email')
     cadCli.email.focus()
     return false
   
   }else if (habilitacao === ""){
   
     alert('Preencha o campo habilitacao')
     cadCli.habilitacao.focus()
     return false
   
   }else if (nascimento === ""){
   
     alert('Preencha o campo data de nascimento')
     cadCli.nascimento.focus()
     return false
   
   }else if (telefone === ""){
   
     alert('Preencha o campo telefone')
     cadCli.htelefone.focus()
     return false
   
   }else if (tipoCliente === ""){
   
     alert('Selecione um tipo de cliente')
     cadCli.tipoCliente.focus()
     return false
   
   }else {
       document.forms["cadCli"].submit()
   
   }
 
 }
 
 
 /*Validação do formulário cadastro de veículo*/

function validarVeiculo(){
 
   let placa = cadVei.numeroPlaca.value
   let marca = cadVei.marca.value
   let modelo = cadVei.modelo.value
   let tipo = cadVei.tipoVeiculo.value
 
   
   if (placa === ""){
     alert('Preencha o campo nº da placa')
     cadVei.numeroPlaca.focus()
     return false
     
   }else if (marca === ""){
   
     alert('Preencha o campo marca')
     cadVei.marca.focus()
     return false
   
   }else if (modelo === ""){
   
     alert('Preencha o campo modelo')
     cadVei.modelo.focus()
     return false
   
   }else if (tipo === ""){
   
     alert('Selecione um tipo de veículo')
     cadVei.tipoVeiculo.focus()
     return false
   
   }else {
       document.forms["cadVei"].submit()
   
   }
 
 }
 
 /*Validação do formulário alteracao de veiculo*/
 
 function validarAlteracaoV(){
 
  
   let marca = cadVei.marca.value
   let modelo = cadVei.modelo.value
   let tipoVeiculo = cadVei.tipoVeiculo.value

   
   if (marca === ""){
   
     alert('Preencha o campo marca')
     cadVei.marca.focus()
     return false
   
   }else if (modelo === ""){
   
     alert('Preencha o campo modelo')
     cadVei.modelo.focus()
     return false
   
   }else if (tipoVeiculo === ""){
   
     alert('Preencha o campo tipoVeiculo')
     cadVei.tipoVeiculo.focus()
     return false
   
   }else {
       document.forms["cadVei"].submit()
   
   }
 
 }
 
 
 /*Validação do formulário criar usuário*/

function validarUsuario(){
 
   let usuario = tLogin.usuario.value
   let senha = tLogin.senha.value
   let funcao = tLogin.funcao.value
 
   
   if (usuario === ""){
     alert('Preencha o campo usuario')
     tLogin.usuario.focus()
     return false
     
   }else if (senha === ""){
   
     alert('Preencha o campo senha')
     tLogin.senha.focus()
     return false
   
   }else if (funcao === ""){
   
     alert('Selecione uma opção')
     tLogin.funcao.focus()
     return false
   
   }else {
       document.forms["tLogin"].submit()
   
   }
 
 }
 
 
 
  /*Validação do formulário alteração usuário*/

function validarAlteracaoU(){
 
   let usuario = tLogin.usuario.value
   let senha = tLogin.senha.value
   let funcao = tLogin.funcao.value
 
   
   if (usuario === ""){
     alert('Preencha o campo usuario')
     tLogin.usuario.focus()
     return false
     
   }else if (senha === ""){
   
     alert('Preencha o campo senha')
     tLogin.senha.focus()
     return false
   
   }else if (funcao === ""){
   
     alert('Selecione uma opção')
     tLogin.funcao.focus()
     return false
   
   }else {
       document.forms["tLogin"].submit()
   
   }
 
 }