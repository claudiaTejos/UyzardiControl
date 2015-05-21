<%-- 
    Document   : AlterarDadosFuncionario
    Created on : 19/05/2015, 10:55:09
    Author     : Claudia Tejos
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
        <div class="empresa"><h1>Uizardy Control</h1></div>
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
        
        <div id="alterarFuncionario" class="cadastrarFuncionario">
            <form  id="controle" action="AlteraDadosFuncionarioServlet" method="POST">
                <label for="inputNomeFuncionario" class="form-label">Nome completo</label>
                <input type="text" id="inputNomeFuncionario" class="form-control"  name="nomeFuncionario"   value="${funcionario.nome}"  required>
                <label for="inputNscimentoFuncionario" class="form-label" > Data de nascimento</label>
                <input type="date" id="inputNascimentoFuncionario"  class="form-control" name="dtNascimento" value="${funcionario.dtNasc}" required>
                <label for="inputEnderecoFuncionario" class="form-label" >Endereco</label>
                <input type="text" id="inputEnderecoFuncionario" class="form-control"  placeholder="Endereco" name="enderecoFuncionario" value="${funcionario.endereco}" required >
                <label for="inputCPFFuncionario" class="form-label">CPF</label>
                <input type="text" id="inputCPFFuncionario"  class="form-control" placeholder="CPF" name="cpfFuncionario" value="${funcionario.cpf}" required >
                <label for="inputRGFuncionario" class="form-label">RG</label>
                <input type="text" id="inputRGFuncionario"  class="form-control" placeholder="RG" name="rgFuncionario"  value="${funcionario.rg}"required >
                <h4 class="genero">Genero</h4>
                <label for="inputGeneroFuncionario" class="genero" >   
                    <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required <c:if test="${funcionario.genero eq 'F'}" >checked</c:if>>F</label>
                <label for="inputGenero" class="genero2">
                <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required <c:if test="${funcionario.genero eq 'M'}">checked</c:if>>M</label>
                <label for="inputCargoFuncionario" class="form-label" id="cargo">Cargo</label>
                <input type="text" id="inputCargoFuncionario"  class="form-control" placeholder="Cargo" name="cargoFuncionario" value="${funcionario.cargo}"required >
                <label for="unidade" class="form-label unidade">Unidade</label>
                <select class="form-control" id="unidadeAtualizar" name="unidadeFuncionarioAtualizar">
                        <c:if test="${not empty listaUnidades}">
                            <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                                <option value="${unidade.idUnidade}" <c:if test="${cliente.idUnidade == unidade.idUnidade}">selected</c:if> >${unidade.nome}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                <label for="inputLoginFuncionario" class="form-label">Login</label>
                <input type="text" id="inputLoginFuncionario"  class="form-control" placeholder="Login" name="loginFuncionario"  value="${funcionario.login}"required >
                <label for="inputSenhaFuncionario" class="form-label">Senha</label>
                <input type="password" id="inputSenhaFuncionario"  class="form-control" placeholder="Senha" name="senhaFuncionario" value="${funcionario.senha}"required >
                <input id="inputHiddenEditar" type="hidden" name="idFuncionario" value="${funcionario.idPessoa}">
                <input type="submit" class="btn btn-success" id="concluir" value="Efetuar mudanças">
                <button type="submit" class="btn btn-danger" id="concluir" formaction="ListarFuncionariosServlet" formmethod="POST">Cancelar</button>

            </form> 
        </div>
                <script src="js/telaPrincipal.js"></script>
    </body>
</html>
