//Variaveis
var btnMatricula = document.getElementById("btnMatricula");
var divMatricula = document.getElementById("matricula");
var btnVendas = document.getElementById("btnVendas");
var divVendas = document.getElementById("vendas");
var btnGerenciamento = document.getElementById("btnGerenciamento");
var divGerenciamento = document.getElementById("gerenciamento");
var divProdutos = document.getElementById("produtos");
var btnNovoAluno = document.getElementById("btnAlunoNovo");
var divNovoAluno = document.getElementById("dadosAluno");
var btnPesquisaAluno = document.getElementById("btnAlunoPesquisa");
var divPesquisaAluno = document.getElementById("listaAluno");
var txtNomeAluno = document.getElementById("nomeAluno");
var inputNomeAluno = document.getElementById("nomeAlunoIncluir");
var btnCadastroFuncionario = document.getElementById("btnCadastroFuncionario");
var divCadastroFuncionario = document.getElementById("cadastrarFuncionario");
var btnRelatorios = document.getElementById("btnRelatorios");
var divRelatorios = document.getElementById("relatorios");
var btnUnidade = document.getElementById("btnUnidade");
var divUnidade = document.getElementById("pesquisaUnidade");
var btnPesquisarUnidade = document.getElementById("btnUnidadePesquisa");
var divPesquisarUnidade = document.getElementById("listarUnidade");
var btnNovaUnidade = document.getElementById("btnNovaUnidade");
var divNovaUnidade = document.getElementById("cadastrarUnidade");

var btnProdutos = document.getElementById("btnProdutos2");
var divProdutos2 = document.getElementById("produtos2");
var divSelecionaCurso = document.getElementById("selecionaCurso");
var btnSelecionaCurso = document.getElementsByClassName("btnSeleciona");

//variaveis de produto
var btnExcluiProduto = document.getElementById("btnExcluiProduto");
var divExcluirProduto = document.getElementById("excluirProduto");
var btnCadastrarProduto = document.getElementById("btnCadastroProduto");
var divCadastrarProduto = document.getElementById("cadastrarProduto");
var inputHiddenPesquisaAluno = document.getElementById("hiddenPesquisa");
var inputHiddenPesquisaUnidade = document.getElementById("hiddenPesquisaUnidade");
var divSelecionaCurso = document.getElementById("selecionaCurso");
var inputHiddenSelecionaCurso = document.getElementById("hiddenSelecionaCurso");


//Funcoes
function mudarOcultoSelecionaCurso(){
    mudarOcultoMatricula();
    if (!divPesquisaAluno.classList.contains("oculto")) {
        divPesquisaAluno.classList.toggle("oculto");
    }
    divSelecionaCurso.classList.toggle("oculto");
}

function atualizaNomeNovoAluno() {
    document.getElementById("nomeNovoAluno").innerHTML = txtNomeAluno.value;
    inputNomeAluno.value = txtNomeAluno.value;
}

function mudarOcultoNovoAluno() {
    if (!divPesquisaAluno.classList.contains("oculto")) {
        divPesquisaAluno.classList.toggle("oculto");
    }
    if (divNovoAluno.classList.contains("oculto")) {
        divNovoAluno.classList.toggle("oculto");
    }
    atualizaNomeNovoAluno();
}

function mudarOcultoPesquisaAluno() {
    mudarOcultoMatricula();
    if (!divNovoAluno.classList.contains("oculto")) {
        divNovoAluno.classList.toggle("oculto");
    }
    if (divPesquisaAluno.classList.contains("oculto")) {
        divPesquisaAluno.classList.toggle("oculto");
    }
}

function mudarOcultoMatricula() {
    if (!divGerenciamento.classList.contains("oculto")) {
        divGerenciamento.classList.toggle("oculto");
    }
    if (!divVendas.classList.contains("oculto")) {
        divVendas.classList.toggle("oculto");
    }
    if (divMatricula.classList.contains("oculto")) {
        divMatricula.classList.toggle("oculto");
        if (!divNovoAluno.classList.contains("oculto")) {
            divNovoAluno.classList.toggle("oculto");
        }
        if (!divPesquisaAluno.classList.contains("oculto")) {
            divPesquisaAluno.classList.toggle("oculto");
        }
    }
    if (!divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
    }
}

function mudarOcultoVendas() {
    if (!divMatricula.classList.contains("oculto")) {
        divMatricula.classList.toggle("oculto");
    }
    if (!divGerenciamento.classList.contains("oculto")) {
        divGerenciamento.classList.toggle("oculto");
    }
    if (divVendas.classList.contains("oculto")) {
        divVendas.classList.toggle("oculto");
    }
    if (!divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
    }
}

function mudarOcultoGerenciamento() {
    if (!divMatricula.classList.contains("oculto")) {
        divMatricula.classList.toggle("oculto");
    }
    if (!divVendas.classList.contains("oculto")) {
        divVendas.classList.toggle("oculto");
    }
    if (divGerenciamento.classList.contains("oculto")) {
        divGerenciamento.classList.toggle("oculto");
    }
    if (!divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
    }
}

function mudarOcultoCadastrarFuncionario(){
    if (!divProdutos2.classList.contains("oculto")) {
        divProdutos2.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }
    if (divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    
}

function mudarOcultoProdutos(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }
    if (divProdutos2.classList.contains("oculto")) {
        divProdutos2.classList.toggle("oculto");
    }
   
}

function mudarOcultoRelatorios(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divProdutos2.classList.contains("oculto")) {
        divProdutos2.classList.toggle("oculto");
    }
    if (!divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }
    if (divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    
}

function mudarOcultoUnidade(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divProdutos2.classList.contains("oculto")) {
        divProdutos2.classList.toggle("oculto");
    }
    if (divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }    
}

function mudarOcultoNovaUnidade() {
    if (!divPesquisarUnidade.classList.contains("oculto")) {
        divPesquisarUnidade.classList.toggle("oculto");
    }
    if (divNovaUnidade.classList.contains("oculto")) {
        divNovaUnidade.classList.toggle("oculto");
    }
}

function mudarOcultoPesquisaUnidade() {
    mudarOcultoGerenciamento();
    mudarOcultoUnidade();
    if (!divNovaUnidade.classList.contains("oculto")) {
        divNovaUnidade.classList.toggle("oculto");
    }
    if (divPesquisarUnidade.classList.contains("oculto")) {
        divPesquisarUnidade.classList.toggle("oculto");
    }
}
   

//Eventos
btnMatricula.addEventListener("click", mudarOcultoMatricula);
btnVendas.addEventListener("click", mudarOcultoVendas);
btnGerenciamento.addEventListener("click", mudarOcultoGerenciamento);
btnNovoAluno.addEventListener("click", mudarOcultoNovoAluno);
txtNomeAluno.addEventListener("keyup", atualizaNomeNovoAluno);


// mudei- claudia

btnCadastroFuncionario.addEventListener("click", mudarOcultoCadastrarFuncionario);
btnProdutos.addEventListener("click",mudarOcultoProdutos);
btnRelatorios.addEventListener("click",mudarOcultoRelatorios);
btnUnidade.addEventListener("click", mudarOcultoUnidade);
btnPesquisarUnidade.addEventListener("click", mudarOcultoPesquisaUnidade);
btnNovaUnidade.addEventListener("click", mudarOcultoNovaUnidade);

//Eventos de Produtos


if(inputHiddenPesquisaAluno !== null){
    mudarOcultoPesquisaAluno();
    inputHiddenPesquisaAluno = null;
}
if(inputHiddenSelecionaCurso !== null){
    mudarOcultoSelecionaCurso();
    inputHiddenSelecionaCurso = null;
}

if (btnSelecionaCurso !== null){
    var i;
    for(i=0; i < btnSelecionaCurso.length; i++){
        btnSelecionaCurso[i].addEventListener("click", mudarOcultoSelecionaCurso);
    }
}

if(inputHiddenPesquisaUnidade !== null){
    mudarOcultoPesquisaUnidade();
    inputHiddenPesquisaUnidade = null;
}