<%-- 
    Document   : telaPrincipal
    Created on : 16/04/2015, 21:35:48
    Author     : senac2012
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
</head>
<body>
	<div class="empresa"><h1>Uizardy Control</h1></div>
    <div class="menu-geral">
    	<ul class="nav nav-pills nav-justified">
            <li><a id="btnMatricula">Matricula</a></li>
            <li><a id="btnVendas">Vendas</a></li>
            <li><a id="btnRelatorios">Relatorios</a></li>
        </ul>
    </div>

    <div id="matricula" class="oculto">
        <div id="pesquisa" class="pesquisa">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Nome aluno" id="nomeAluno">
                </div>
                <form formmethod="POST" formaction="pesquisarAluno" ><button id="btnAlunoPesquisa" class="btn btn-default">Pesquisa</button></form>
                <button type="button" id="btnAlunoNovo" class="btn btn-primary">Novo</button>
            </form>
        </div>

        <div id="listaAluno" class="alunos-na-lista oculto">
            <table class="table table-striped">
              <tr class="tabelaInicio">
                <td>Matricula</td>
                <td>Nome</td>
                <td>Ações</td>
              </tr>
              <c:forEach items="${listaClientes}" var="cliente" varStatus="stat">
                    <tr>
                        <td><c:out value="${cliente.idPessoa}" /></td>
                        <td><c:out value="${cliente.nome}" /></td>
                        <td><button type="button" id="btnAlunoAtualiza" class="btn btn-info" value="${aluno.idPessoa}">Atualizar</button></td>
                    </tr>
              </c:forEach>
            </table>
        </div> 

        <div id="selecionaCurso" class="matricula-aluno oculto">
            <form>
                <h2 id=""nomeAlunoMatricula>Nome do aluno</h2>
                <select class="form-control">
                    <option >Curso</option>
                    <option value="ingles">Ingles</option>
                    <option value="frances">Frances</option>
                    <option value="espanhol">Espanhol</option>
                </select>

                <br>

                <select class="form-control">
                    <option >Modulo</option>
                    <option value="1">Modulo 1</option>
                    <option value="2">Modulo 2</option>
                    <option value="3">Modulo 3</option>
                    <option value="4">Modulo 4</option>
                    <option value="5">Modulo 4</option>
                </select>
                <br>
                <select class="form-control">
                    <option value="1">Manha 9h30</option>
                    <option value="2">Manha 11h30</option>
                    <option value="3">Tarde 2h45</option>
                    <option value="4">Tarde 4h50</option>
                    <option value="5">Noite 18h</option>
                    <option value="6">Noite 20h</option>
                </select>
                <br> 
                <button class="btn btn-lg btn-primary btn-block" type="submit"> Matricular Aluno</button>	
            </form>
        </div>

        <br>
        <br>

        <div id="dadosAluno" class="oculto">
            <form>
                <h3 class="form-signin-heading" id="nomeNovoAluno">Nome do aluno</h3>
                <label for="inputDtNascimento" class="sr-only"> Data de nascimento</label>
                <input type="date" id="inputDtNascimento" class="form-control" placeholder="Data de nascimento" required>
                <label for="inputEndereco" class="sr-only">Endereco</label>
                <input type="text" id="inputEndereco" class="form-control" placeholder="Endereco" required >
                <label for="inputCPF" class="sr-only">CPF</label>
                <input type="text" id="inputCPF" class="form-control" placeholder="CPF" required >
                <label for="inputRG" class="sr-only">RG</label>
                <input type="text" id="inputRG" class="form-control" placeholder="RG" required >
                <h4>Genero</h4>
                <label for="inputGenero" class="radio-inline">   
                <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required>F</label>
                <label for="inputGenero" class="radio-inline">
                <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required >M</label>
                <select class="form-control">
                    <option value="1">Rio de Janeiro</option>
                    <option value="2">Sao Paulo</option>
                    <option value="3">Brasilia</option>
                    <option value="4">Bahia</option>
                    <option value="5">Pernambuco</option>
                    <option value="6">Para</option>
                </select>
            </form>
        </div>
    </div>
    
    <div id="vendas" class="oculto">
        <br><br>Vendas
    </div>
    
    <div id="relatorios" class="relatorios oculto">
        <ul class="nav nav-tabs">
          <li role="presentation" class="active"><a href="#">Data de Inicio</a></li>
          <li role="presentation"><a href="#">Data de Fim</a></li>
          <li role="presentation"><a href="#">Unidade</a></li>
          <li role="presentation"><a href="#">Curso</a></li>
          <li role="presentation"><a href="#">Modulo</a></li>
        </ul>
    </div>
 
    <script src="js/telaPrincipal.js"></script>
</body>
</html>