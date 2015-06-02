function gerarLinha(item){
	var linha = document.createElement("tr");
	var cn = document.createElement("td");
	cn.textContent = item.unidade;
	var ci = document.createElement("td");
	ci.textContent = item.nomeCurso;
        var cm = document.createElement("td");
	cm.textContent = item.moduloCurso;
        var ct = document.createElement("td");
	ct.textContent = item.total;
	linha.appendChild(cn);
	linha.appendChild(ci);
        linha.appendChild(cm);
        linha.appendChild(ct);
	return linha;
    }
			
    function recriarTabela(){
        var itensTabela = document.getElementById("linhasTabela");
	for(var i in dadosUnidades){
            itensTabela.appendChild(gerarLinha(dadosUnidades[i]));
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
    
    function ordenarPorCurso(a,b){
	if(a.nomeCurso < b.nomeCurso) return -1;
	if(a.nomeCurso > b.nomeCurso) return 1;
	return 0;
    }
    
    function ordenarPorModulo(a,b){
	if(a.moduloCurso < b.moduloCurso) return -1;
	if(a.moduloCurso > b.moduloCurso) return 1;
	return 0;
    }
			
    function ordenar(e){
	var campo = e.target.id;
	if(campo == "cellUnidade") dadosUnidades.sort(ordenarPorUnidade);
	if(campo == "cellCurso") dadosUnidades.sort(ordenarPorCurso);
        if(campo == "cellModulo") dadosUnidades.sort(ordenarPorModulo);
        if(campo == "cellTotal") dadosUnidades.sort(ordenarPorTotal);
	destruirTabela();
        recriarTabela();
    }
			
    recriarTabela();
    document.getElementById("cellUnidade").addEventListener("click",ordenar);
    document.getElementById("cellCurso").addEventListener("click",ordenar);
    document.getElementById("cellModulo").addEventListener("click",ordenar);
    document.getElementById("cellTotal").addEventListener("click",ordenar);