//Variaveis

// matricula
var btnMatricula = document.getElementById("btnMatricula");
var divMatricula = document.getElementById("matricula");

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
var btnCadastrarUnidade = document.getElementById("btnNovaUnidade");
var divCadastrarUnidade = document.getElementById("cadastrarUnidade");
var btnCadastrarCurso = document.getElementById("btnNovoCurso");
var divCadastrarCurso = document.getElementById("cadastrarCurso");
var btnProdutos = document.getElementById("btnProdutos2");
var divProdutos2 = document.getElementById("produtos2");
var divSelecionaCurso = document.getElementById("selecionaCurso");
var btnSelecionaCurso = document.getElementsByClassName("btnSeleciona");


// vendas
var btnVendas = document.getElementById("btnVendas");
var divVendas = document.getElementById("vendas");

// gerenciamento 
var btnGerenciamento = document.getElementById("btnGerenciamento");
var divGerenciamento = document.getElementById("gerenciamento");

// funcionario
var btnFuncionario = document.getElementById("btnFuncionario");
var divFuncionario = document.getElementById("pesquisaFuncionario");
var btnPesquisarFuncionario = document.getElementById("btnFuncionarioPesquisa");
var divPesquisaFuncionario = document.getElementById("listarFuncionario");
var btnNovoFuncionario = document.getElementById("btnNovoFuncionario");
var divNovoFuncionario = document.getElementById("cadastrarFuncionario");

// unidade
var btnUnidade = document.getElementById("btnUnidade");
var divUnidade = document.getElementById("pesquisaUnidade");
var btnPesquisarUnidade = document.getElementById("btnUnidadePesquisa");
var divPesquisarUnidade = document.getElementById("listarUnidade");
var btnNovaUnidade = document.getElementById("btnNovaUnidade");
var divNovaUnidade = document.getElementById("cadastrarUnidade");

// produtos
var btnProdutos = document.getElementById("btnProdutos");
var divProdutos = document.getElementById("produtos");
var divListarProduto = document.getElementById("listarProdutos");
var btnCadastrarProduto = document.getElementById("btnCadastroProduto");
var divCadastrarProduto = document.getElementById("cadastrarProduto");

// curso
var divSelecionaCurso = document.getElementById("selecionaCurso");
var btnSelecionaCurso = document.getElementsByClassName("btnSeleciona");
var divSelecionaCurso = document.getElementById("selecionaCurso");


// relatorios
var btnRelatorios = document.getElementById("btnRelatorios");
var divRelatorios = document.getElementById("relatorios");

// hidden
var inputHiddenPesquisaAluno = document.getElementById("hiddenPesquisa");
var inputHiddenPesquisaUnidade = document.getElementById("hiddenPesquisaUnidade");
var inputHiddenSelecionaCurso = document.getElementById("hiddenSelecionaCurso");
var inputHiddenPesquisaFuncionario = document.getElementById("hiddenPesquisaFuncionario");


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

 ///////////////////// funcoes menu principal
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
}

//////////////// funcoes funcionario
function mudarOcultoFuncionario(){
    if (!divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divCadastrarCurso.classList.contains("oculto")) {
        divCadastrarCurso.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (!divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }
    if (divFuncionario.classList.contains("oculto")) {
        divFuncionario.classList.toggle("oculto");
    }
    
}

function mudarOcultoNovoFuncionario() {
    if (!divPesquisaFuncionario.classList.contains("oculto")) {
        divPesquisaFuncionario.classList.toggle("oculto");
    }
    if (divNovoFuncionario.classList.contains("oculto")) {
        divNovoFuncionario.classList.toggle("oculto");
    }
}

function mudarOcultoPesquisaFuncionario() {
    mudarOcultoGerenciamento();
    mudarOcultoFuncionario();
    if (!divNovoFuncionario.classList.contains("oculto")) {
        divNovoFuncionario.classList.toggle("oculto");
    }
    if (divPesquisaFuncionario.classList.contains("oculto")) {
        divPesquisaFuncionario.classList.toggle("oculto");
    }
}


////////////////// funcoes produtos
function mudarOcultoProdutos(){
    if (!divFuncionario.classList.contains("oculto")) {
        divFuncionario.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divCadastrarCurso.classList.contains("oculto")) {
        divCadastrarCurso.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (!divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }
    if (divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
        divListarProduto.classList.toggle(("oculto"));
    } 
}

function mudarOcultoCadastrarProduto() {
    
    if (!divListarProduto.classList.contains("oculto")){
        divListarProduto.classList.toggle("oculto");
    }
    
    if (divCadastrarProduto.classList.contains("oculto")){
        divCadastrarProduto.classList.toggle("oculto");
    }
}

///////////// funcoes relatorios
function mudarOcultoRelatorios(){
    if (!divFuncionario.classList.contains("oculto")) {
        divFuncionario.classList.toggle("oculto");
    }
    if (!divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
    }
    if (!divCadastrarCurso.classList.contains("oculto")) {
        divCadastrarCurso.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (!divUnidade.classList.contains("oculto")) {
        divUnidade.classList.toggle("oculto");
    }
    if (divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    
}

///////////// funcoes unidade
function mudarOcultoUnidade(){
    if (!divFuncionario.classList.contains("oculto")) {
        divFuncionario.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divProdutos.classList.contains("oculto")) {
        divProdutos.classList.toggle("oculto");
    }
    if (!divCadastrarCurso.classList.contains("oculto")) {
        divCadastrarCurso.classList.toggle("oculto");
    }
    if (divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }    
}

function mudarOcultoNovoCurso(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divProdutos2.classList.contains("oculto")) {
        divProdutos2.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (divCadastrarCurso.classList.contains("oculto")) {
        divCadastrarCurso.classList.toggle("oculto");
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

///////////// eventos de matricula
btnMatricula.addEventListener("click", mudarOcultoMatricula);
btnNovoAluno.addEventListener("click", mudarOcultoNovoAluno);
txtNomeAluno.addEventListener("keyup", atualizaNomeNovoAluno);

///////////// eventos de vendas
btnVendas.addEventListener("click", mudarOcultoVendas);

///////////// eventos de gerenciamento
btnGerenciamento.addEventListener("click", mudarOcultoGerenciamento);

///////////// eventos de funcionario
btnFuncionario.addEventListener("click", mudarOcultoFuncionario);
btnPesquisarFuncionario.addEventListener("click", mudarOcultoPesquisaFuncionario);
btnNovoFuncionario.addEventListener("click", mudarOcultoNovoFuncionario);

///////////// eventos de produtos
btnProdutos.addEventListener("click",mudarOcultoProdutos);
btnCadastrarProduto.addEventListener("click", mudarOcultoCadastrarProduto);

///////////// eventos de relatorios
btnRelatorios.addEventListener("click",mudarOcultoRelatorios);
btnCadastrarUnidade.addEventListener("click", mudarOcultoNovaUnidade);
btnCadastrarCurso.addEventListener("click", mudarOcultoNovoCurso);


///////////// eventos de unidade
btnUnidade.addEventListener("click", mudarOcultoUnidade);
btnPesquisarUnidade.addEventListener("click", mudarOcultoPesquisaUnidade);
btnNovaUnidade.addEventListener("click", mudarOcultoNovaUnidade);






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
if(inputHiddenPesquisaFuncionario !== null){
    mudarOcultoPesquisaFuncionario();
    inputHiddenPesquisaFuncionario = null;
}