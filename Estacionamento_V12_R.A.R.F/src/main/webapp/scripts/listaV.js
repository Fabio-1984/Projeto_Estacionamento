/**
 * 
 */
 
 const buscarV = document.getElementById('buscarV');
const tabelaV = document.getElementById('tabelaV');


buscarV.addEventListener('keyup', () => {
   let expressao = buscarV.value.toLowerCase();
   
   console.log(expressao);
   
   let linhas = tabelaV.getElementsByTagName('tr');
   
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