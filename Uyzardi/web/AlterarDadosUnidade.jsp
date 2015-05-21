<%-- 
    Document   : AlteraDadosUnidade
    Created on : 19/05/2015, 12:02:02
    Author     : Claudia Tejos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <div id="atualizarUnidade" class="atualizarUnidade">
            <form  id="controle" action="AlterarDadosUnidadeServlet" method="POST">
                <label for="inputNomeUnidade" class="form-label">Nome da Unidade</label>
                <input type="text" id="inputNomeUnidade" class="form-control" placeholder="nome da unidade" name="nomeUnidade" value="${unidade.nome}"  required>
                <label for="inputEnderecoUnidade" class="form-label">Endereco da Unidade</label>
                <input id="inputEnderecoUnidade" placeholder="endereco" class="form-control" name="enderecoUnidade" value="${unidade.endereco}" required>
                <label for="inputCidadeUnidade"class="form-label">Cidade da Unidade</label>
                <input id="inputCidadeUnidade" placeholder="nome da cidade" class="form-control" name="cidadeUnidade" value="${unidade.cidade}" required>
                <input id="inputHiddenEditar" type="hidden" name="idUnidade" value="${unidade.idUnidade}">
                <input type="submit" class="btn btn-success" id="concluir" value="Efetuar Mudanças">
                <button type="submit" class="btn btn-danger" id="concluir" formaction="ListarUnidadeServlet" formmethod="POST">Cancelar</button>
            </form> 
        </div>
                <script src="js/telaPrincipal.js"></script>
    </body>
</html>
