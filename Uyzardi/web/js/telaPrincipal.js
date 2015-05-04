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

// variaveis de gerenciamento
var btnCadastroFuncionario = document.getElementById("btnCadastroFuncionario");
var divCadastroFuncionario = document.getElementById("cadastrarFuncionario");
var btnCadastrarProduto = document.getElementById("btnCadastroProduto");
var divCadastrarProduto = document.getElementById("cadastrarProduto");
var btnRelatorios = document.getElementById("btnRelatorios");
var divRelatorios = document.getElementById("relatorios");
var btnCadastrarUnidade = document.getElementById("btnNovaUnidade");
var divCadastrarUnidade = document.getElementById("cadastrarUnidade");
var inpHiddenPesquisaAluno = document.getElementById("hiddenPesquisa");

//Funcoes
function atualizaNomeNovoAluno() {
    document.getElementById("nomeNovoAluno").innerHTML = txtNomeAluno.value;
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
    if (!divCadastrarProduto.classList.contains("oculto")) {
        divCadastrarProduto.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    
}

function mudarOcultoCadastrarProduto(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (divCadastrarProduto.classList.contains("oculto")) {
        divCadastrarProduto.classList.toggle("oculto");
    }
    
}
function mudarOcultoRelatorios(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divCadastrarProduto.classList.contains("oculto")) {
        divCadastrarProduto.classList.toggle("oculto");
    }
    if (!divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    if (divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    
}

function mudarOcultoNovaUnidade(){
    if (!divCadastroFuncionario.classList.contains("oculto")) {
        divCadastroFuncionario.classList.toggle("oculto");
    }
    if (!divCadastrarProduto.classList.contains("oculto")) {
        divCadastrarProduto.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (divCadastrarUnidade.classList.contains("oculto")) {
        divCadastrarUnidade.classList.toggle("oculto");
    }
    
}

//Eventos
btnMatricula.addEventListener("click", mudarOcultoMatricula);
btnVendas.addEventListener("click", mudarOcultoVendas);
btnGerenciamento.addEventListener("click", mudarOcultoGerenciamento);
btnNovoAluno.addEventListener("click", mudarOcultoNovoAluno);
txtNomeAluno.addEventListener("keyup", atualizaNomeNovoAluno);
btnCadastroFuncionario.addEventListener("click", mudarOcultoCadastrarFuncionario);
btnCadastrarProduto.addEventListener("click",mudarOcultoCadastrarProduto);
btnRelatorios.addEventListener("click",mudarOcultoRelatorios);
btnCadastrarUnidade.addEventListener("click", mudarOcultoNovaUnidade);
if(inpHiddenPesquisaAluno !== null){
    mudarOcultoPesquisaAluno();
    inpHiddenPesquisaAluno = null;
}