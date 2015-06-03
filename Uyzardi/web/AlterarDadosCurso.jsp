<%-- 
    Author: Cauê Camargo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
        <title>Uizardy Control</title>
    </head>
    <body>
        <div id="controleInicio">
        <h1 class="empresa">
        <img src="css/logoPI.png"  height="110" width="140" class="imagem2">
        Uizardy Control</h1>
        </div>  
        <div class="menu-geral">
            <ul class="nav nav-pills nav-justified">
                <li><a id="btnMatricula">Matricula</a></li>
                <li><a id="btnVendas" href="ListarProdutosVenda">Vendas</a></li>
                <li><a id="btnGerenciamento">Gerenciamento</a></li>
            </ul>
        </div>
        <div class="btn-group-vertical" role="group" id="botoesGerenciamento">
            <div id="btnFuncionario" class="btn btn-primary">Funcionarios</div>
            <div id="btnCurso" class="btn btn-info">Curso</div>
            <a id="btnProdutos" class="btn btn-primary" href="ListarProdutosServlet">Produtos</a>
            <div id="btnUnidade" class="btn btn-info">Unidades</div>
            <div id="btnRelatorios" class="btn btn-primary">Relatorios</div>
        </div>
        
        <div id="atualizarCurso" class="atualizarCurso">
            <form  id="controle" action="AlterarDadosCursoServlet" method="POST">
                <input id="inputHiddenEditar" type="hidden" name="idCurso" value="${curso.idCurso}">
                <label for="inputNomeCurso" class="form-label">Nome Curso</label>
                <input type="text" id="inputNomeCurso" class="form-control" placeholder="curso" name="nomeCurso" value="${curso.nomeCurso}" required>
                <label for="inputModuloCurso" class="form-label">Módulo</label>
                <input id="inputIdioma" placeholder="moduloCurso" class="form-control" name="moduloCurso" value="${curso.moduloCurso}" required>
                <label for="inputSala"class="form-label">Sala</label>
                <input id="moduloModulo" placeholder="sala" class="form-control" name="salaCurso" value="${curso.salaCurso}" required>
                <label for="inputValor" class="form-label">Valor</label>
                <input type="text" id="inputValor" class="form-control" placeholder="valor" name="valor" value="${curso.valor}" required >
                <label for="inputVagas" class="form-label">Vagas</label>
                <input type="text" id="inputVagas" class="form-control" placeholder="vagas" name="vagas" value="${curso.qtdVagas}" required>
                <label for="unidade" class="form-label unidade">Unidade</label>
                <select class="form-control" id="unidade" name="idUnidade" value="${curso.idUnidade}" required>
                    <c:if test="${not empty listaUnidades}">
                        <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                            <option value="${unidade.idUnidade}">${unidade.nome}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <label for="periodo" class="form-label unidade">Periodo</label>
                <select class="form-control" id="periodo" name="periodo" value="${curso.periodo}" required>
                    <option value="1">Manha 9h30</option>
                    <option value="2">Manha 11h30</option>
                    <option value="3">Tarde 14h45</option>
                    <option value="4">Tarde 16h50</option>
                    <option value="5">Noite 18h</option>
                    <option value="6">Noite 20h</option>
                </select>
                <h4 class="genero">Status</h4>
                <label for="inputStatusCurso" class="genero">   
                <input type="radio" id="inlineRadioA" name="inlineRadioOptionsCurso" value="A" <c:if test="${curso.status eq 'A'}"> checked </c:if> required>Ativo</label>
                <label for="inputGenero" class="genero2">
                <input type="radio" id="inlineRadioI" name="inlineRadioOptionsCurso" value="I" <c:if test="${curso.status eq 'I'}">checked</c:if>required >Inativo</label>
                <input type="submit" class="btn btn-success" id="concluir" value="Efetuar Mudanças">
                <button type="submit" class="btn btn-danger" id="concluir" formaction="ListarCursoServlet" formmethod="POST">Cancelar</button>
            </form> 
        </div>
        <script src="js/telaPrincipal.js"></script>
    </body>
</html>
