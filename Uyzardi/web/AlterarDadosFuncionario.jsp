<%-- 
    Document   : AlterarDadosFuncionario
    Created on : 19/05/2015, 10:55:09
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
            <a id="btnProdutos2" class="btn btn-info" href="ListarProdutosServlet">Produtos</a>
            <div id="btnNovoCurso" class="btn btn-primary">Curso</div>
            <div id="btnRelatorios" class="btn btn-primary">Relatorios</div>
        <div id="btnFuncionario" class="btn btn-primary">Funcionario</div>
        <a id="btnProdutos" class="btn btn-info" href="ListarProdutosServlet">Produtos</a>
        <div id="btnUnidade" class="btn btn-primary">Unidades</div>
        <div id="btnRelatorios" class="btn btn-info">Relatorios</div>
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
                <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required>F</label>
                <label for="inputGenero" class="genero2">
                <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required >M</label>
                <label for="inputCargoFuncionario" class="form-label" id="cargo">Cargo</label>
                <input type="text" id="inputCargoFuncionario"  class="form-control" placeholder="Cargo" name="cargoFuncionario" value="${funcionario.cargo}"required >
                <label for="unidade" class="form-label unidade">Unidade</label>
                    <select class="form-control" id="unidade" name="unidadeFuncionario" value="${funcionario.unidade}">
                        <option value="1">São Paulo</option>
                        <option value="2">Rio de Janeiro</option>
                        <option value="5">Belo Horizonte </option>
                        <option value="6">Curitiba</option>
                        <option value="7">Porto Alegre</option>
                        <option value="8">Florianopolis</option>
                        <option value="9">Salvador</option>
                        <option value="10">Recife</option>
                        <option value="11">Goiania</option>
                        <option value="12">Manaus</option>
                        <option value="13">Belem</option>
                        <option value="14">Brasilia</option>
                    </select>
                <label for="inputLoginFuncionario" class="form-label">Login</label>
                <input type="text" id="inputLoginFuncionario"  class="form-control" placeholder="Login" name="loginFuncionario"  value="${funcionario.login}"required >
                <label for="inputSenhaFuncionario" class="form-label">Senha</label>
                <input type="password" id="inputSenhaFuncionario"  class="form-control" placeholder="Senha" name="senhaFuncionario" value="${funcionario.senha}"required >
                <input id="inputHiddenEditar" type="hidden" name="idFuncionario" value="${funcionario.idPessoa}">
                <input type="submit" class="btn btn-success" id="mudancas" value="Efetuar mudanças">
                <button type="submit" class="btn btn-danger" id="mudancas" formaction="ListarFuncionariosServlet" formmethod="POST">Cancelar</button>

            </form> 
        </div>
    </body>
</html>
