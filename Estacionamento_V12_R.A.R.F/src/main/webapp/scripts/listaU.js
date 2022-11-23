/**
 * 
 */
 
 
  const buscarU = document.getElementById('buscarU');
const tabela = document.getElementById('tabela');


buscarU.addEventListener('keyup', () => {
   let expressao = buscarU.value.toLowerCase();
   
   console.log(expressao);
   
   let linhas = tabela.getElementsByTagName('tr');
   
   console.log(linhas);
   for(let posicao in linhas){
   
   if(true === isNaN(posicao)){
   continue;
   
   }
   
    let conteudoDaLinha = linhas[posicao].innerHTML.toLowerCase();
    
    if (true === conteudoDaLinha.includes(expressao)){
       linhas[posicao].style.display = '';
       
       
    }else{
       linhas[posicao].style.display = 'none';
    }
    
   
   }
});