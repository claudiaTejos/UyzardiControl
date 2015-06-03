function gerarLinha(item){
    var linha = document.createElement("tr");
    var cn = document.createElement("td");
    cn.textContent = item.unidade;
    var ci = document.createElement("td");
    ci.textContent = item.idiomaProduto;
    var cm = document.createElement("td");
    cm.textContent = item.nomeProduto;
    var ct = document.createElement("td");
    ct.textContent = item.moduloProduto;
    var cdt = document.createElement("td");
    cdt.textContent = item.total;
    linha.appendChild(cn);
    linha.appendChild(ci);
    linha.appendChild(cm);
    linha.appendChild(ct);
    linha.appendChild(cdt);
    return linha;
}
			
function recriarTabela(){
    var itensTabela = document.getElementById("linhasTabela");
    for(var i in dados){
        itensTabela.appendChild(gerarLinha(dados[i]));
    }
}
			
function destruirTabela(){
    var itensTabela = document.getElementById("linhasTabela");
    while(itensTabela.childNodes.length > 0){
        itensTabela.removeChild(itensTabela.childNodes[0]);
    }
}
			
function ordenarPorTotal(a,b){
    if(a.total < b.total) return -1;
    if(a.total > b.total) return 1;
    return 0;
}
			
function ordenarPorUnidade(a,b){
    if(a.unidade < b.unidade) return -1;
    if(a.unidade > b.unidade) return 1;
    return 0;
}
    
function ordenarPorIdioma(a,b){
    if(a.idiomaProduto < b.idiomaProduto) return -1;
    if(a.idiomaProduto > b.idiomaProduto) return 1;
    return 0;
}
    
function ordenarPorModulo(a,b){
    if(a.moduloProduto < b.moduloProduto) return -1;
    if(a.moduloProduto > b.moduloProduto) return 1;
    return 0;
}

function ordenarPorProduto(a,b){
    if(a.nomeProduto < b.nomeProduto) return -1;
    if(a.nomeProduto > b.nomeProduto) return 1;
    return 0;
}
			
function ordenar(e){
    var campo = e.target.id;
    if(campo == "cellUnidade") dados.sort(ordenarPorUnidade);
    if(campo == "cellIdioma") dados.sort(ordenarPorIdioma);
    if(campo == "cellModulo") dados.sort(ordenarPorModulo);
    if(campo == "cellProduto") dados.sort(ordenarPorProduto);
    if(campo == "cellTotal") dados.sort(ordenarPorTotal);
    destruirTabela();
    recriarTabela();
}
			
recriarTabela();
document.getElementById("cellUnidade").addEventListener("click",ordenar);
document.getElementById("cellIdioma").addEventListener("click",ordenar);
document.getElementById("cellProduto").addEventListener("click",ordenar);
document.getElementById("cellModulo").addEventListener("click",ordenar);
document.getElementById("cellTotal").addEventListener("click",ordenar);