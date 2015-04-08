//Variaveis
var btnMatricula = document.getElementById("btnMatricula");
var divMatricula = document.getElementById("matricula");
var btnVendas = document.getElementById("btnVendas");
var divVendas = document.getElementById("vendas");
var btnRelatorios = document.getElementById("btnRelatorios");
var divRelatorios = document.getElementById("relatorios");
var btnNovoAluno = document.getElementById("btnAlunoNovo");
var divNovoAluno = document.getElementById("dadosAluno");
var btnPesquisaAluno = document.getElementById("btnAlunoPesquisa");
var divPesquisaAluno = document.getElementById("listaAluno");
var txtNomeAluno = document.getElementById("nomeAluno");

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
    if (!divNovoAluno.classList.contains("oculto")) {
        divNovoAluno.classList.toggle("oculto");
    }
    if (divPesquisaAluno.classList.contains("oculto")) {
        divPesquisaAluno.classList.toggle("oculto");
    }
}

function mudarOcultoMatricula() {
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (!divVendas.classList.contains("oculto")) {
        divVendas.classList.toggle("oculto");
    }
    if (divMatricula.classList.contains("oculto")) {
        divMatricula.classList.toggle("oculto");
    }
}

function mudarOcultoVendas() {
    if (!divMatricula.classList.contains("oculto")) {
        divMatricula.classList.toggle("oculto");
    }
    if (!divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
    if (divVendas.classList.contains("oculto")) {
        divVendas.classList.toggle("oculto");
    }
}

function mudarOcultoRelatorio() {
    if (!divMatricula.classList.contains("oculto")) {
        divMatricula.classList.toggle("oculto");
    }
    if (!divVendas.classList.contains("oculto")) {
        divVendas.classList.toggle("oculto");
    }
    if (divRelatorios.classList.contains("oculto")) {
        divRelatorios.classList.toggle("oculto");
    }
}

console.log("ok");

//Eventos
btnMatricula.addEventListener("click", mudarOcultoMatricula);
btnVendas.addEventListener("click", mudarOcultoVendas);
btnRelatorios.addEventListener("click", mudarOcultoRelatorio);
btnNovoAluno.addEventListener("click", mudarOcultoNovoAluno);
btnPesquisaAluno.addEventListener("click", mudarOcultoPesquisaAluno);
txtNomeAluno.addEventListener("onkeyup", atualizaNomeNovoAluno);
