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
        <title>Uizardy Control</title>
</head>
<body>
    <c:if test="${not empty clickBtnPesquisa}">
        <input type="hidden" id="hiddenPesquisa" value="true">
    </c:if>
    <c:if test="${not empty clickBtnPesquisaUnidade}">
        <input type="hidden" id="hiddenPesquisaUnidade" value="true">
    </c:if>
    <c:if test="${not empty clickBtnPesquisaFuncionario}">
        <input type="hidden" id="hiddenPesquisaFuncionario" value="true">
    </c:if>
    <c:if test="${not empty clickBtnPesquisaCurso}">
        <input type="hidden" id="hiddenPesquisaCurso" value="true">
    </c:if>
    <c:if test="${resultadoIncluir}">
        <input type="hidden" id="hiddenSelecionaCurso" value="true">
    </c:if>
        
    <div class="empresa"><h1>Uizardy Control</h1></div>
    <div class="menu-geral">
    	<ul class="nav nav-pills nav-justified">
            <li><a id="btnMatricula">Matricula</a></li>
            <li><a id="btnVendas" href="ListarProdutosVenda">Vendas</a></li>
            <li><a id="btnGerenciamento">Gerenciamento</a></li>
        </ul>
    </div>

    <div id="matricula" class="oculto">
        <div id="pesquisa" class="pesquisa">
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Nome aluno" id="nomeAluno" name="nomeAluno" >
              </div>
                <button formaction="pesquisarCliente" formmethod="POST" id="btnAlunoPesquisa" class="btn btn-default glyphicon glyphicon-search"></button>
              <div id="btnAlunoNovo" class="btn btn-primary">Novo</div>
            </form>
        </div>

        <div id="listaAluno" class="alunos-na-lista oculto">
            <c:if test="${not empty listaClientes}">
                <table class="table table-striped">
                <tr class="tabelaInicio">
                    <td>Matricula</td>
                    <td>Nome</td>
                    <td>Ações</td>
                </tr>
                <c:forEach items="${listaClientes}" var="cliente" varStatus="stat">
                    <tr><form>
                        <input type="hidden" name="btnAcoesHiddenIDCliente" value="${cliente.idPessoa}">
                            <td><c:out value="${cliente.idPessoa}" /></td>
                            <td><c:out value="${cliente.nome}" /></td>
                            <td>
                                <button class="btn btn-info btnAtualiza" formmethod="POST" formaction="selecionaCliente">Atualizar</button> 
                                <button class="btn btn-info matriculaBtn" formmethod="POST" formaction="listaMatricula">Matricula</button>
                            </td>
                        </form>
                    </tr>
                  </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty listaClientes}">
                <div class="aviso">Não foi encontrado nenhum resultados.</div>
            </c:if>
        </div> 
        
        <div id="selecionaCurso" class="matricula-aluno oculto">
            <form>
                <c:if test="${not empty cliente}">
                <h2 id="nomeAlunoMatricula">${cliente.nome}</h2>
                    <input type="hidden" id="hiddenPesquisa" value="${cliente.idPessoa}">
                    <c:if test="${not empty listaMatricula}">
                        <table class="table table-striped">
                            <tr>
                                <th>Curso</th>
                                <th>Modulo</th>
                                <th>Status</th>
                            </tr>
                            <c:forEach items="${listaMatricula}" var="matricula" varStatus="stat">
                                <tr>
                                    <td><c:out value="${matricula.idMatricul}" /></td>
                                    <td><c:out value="${matricula.dataMatricula}" /></td>
                                    <td><c:out value="${matricula.statusMatricula}" /></td>
                                </tr>
                          </c:forEach>
                        </table>
                    </c:if>
                    <select class="form-control" name="optionCurso">
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
                </c:if>
            </form>
        </div>

        <br>
        <br>

        <div id="dadosAluno" class="oculto">
            <form formaction="incluirCliente" formmethod="POST" id="controle">
                <h3 class="form-signin-heading" id="nomeNovoAluno">Nome do aluno</h3>
                <input type="hidden" name="nomeAlunoIncluir" id="nomeAlunoIncluir"></input>
                <label for="inputDtNascimento" class="form-label"> Data de nascimento</label>
                <input type="date" id="inputDtNascimento" class="form-control" placeholder="Data de nascimento" name="dt_Nascimento"required>
                <label for="inputEndereco" class="form-label">Endereco</label>
                <input type="text" id="inputEndereco" class="form-control" placeholder="Endereco" name="endereco" required >
                <label for="inputCPF" class="form-label">CPF</label>
                <input type="text" id="inputCPF" class="form-control" placeholder="CPF" name="cpf"required >
                <label for="inputRG" class="form-label">RG</label>
                <input type="text" id="inputRG" class="form-control" placeholder="RG" name="rg" required >
                <h4 class="genero">Genero</h4>
                <label for="inputGenero" class="genero">   
                <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required>F</label>
                <label for="inputGenero" class="genero2">
                <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required >M</label>
                <label for="unidade" class="form-label unidade">Unidade</label>
                <select class="form-control" id="unidade" name="unidadeCliente">
                    <c:if test="${not empty listaUnidades}">
                        <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                            <option value="${unidade.idUnidade}">${unidade.nome}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <button  class="btn btn-success" id="concluir" formaction="incluirCliente" formmethod="POST">Concluir</button>
            </form>
        </div>
        <c:if test="${not empty cliente}">
            <div id="dadosAlunoAtualizar" class="oculto">
                <c:if test="${controleAtualizarCliente}">
                    <div class="aviso">Cliente atualizado.</div>
                </c:if>
                <form action="atualizarCliente" method="POST" id="controle">
                    <input type="hidden" name="idAlunoAtualizar" value="${cliente.idPessoa}">
                    <label for="inputNomeAtualizar" class="form-label">Nome</label>
                    <input type="text" name="nomeAlunoAtualizar" id="inputNomeAtualizar" placeholder="Nome Completo" class="form-control" required value="${cliente.nome}"></input>
                    <label for="inputDtNascimentoAtualizar" class="form-label">Data de nascimento</label>
                    <input type="date" id="inputDtNascimentoAtualizar" class="form-control" placeholder="Data de nascimento" name="dtNascimentoAtualizar" required value="${cliente.dtNasc}">
                    <label for="inputEnderecoAtualizar" class="form-label">Endereco</label>
                    <input type="text" id="inputEnderecoAtualizar" class="form-control" placeholder="Endereco" name="enderecoAtualizar" required value="${cliente.endereco}">
                    <label for="inputCPFAtualizar" class="form-label">CPF</label>
                    <input type="text" id="inputCPFAtualizar" class="form-control" placeholder="CPF" name="cpfAtualizar"required value="${cliente.cpf}">
                    <label for="inputRGAtualizar" class="form-label">RG</label>
                    <input type="text" id="inputRGAtualizar" class="form-control" placeholder="RG" name="rgAtualizar" required value="${cliente.rg}">
                    <h4 class="genero">Genero</h4>
                    <label for="inlineRadioFAtualizar" class="genero">   
                    <input type="radio" id="inlineRadioFAtualizar" name="inlineRadioOptions" value="F"  required <c:if test="${cliente.genero eq 'F'}">checked</c:if>>F</label>
                    <label for="inlineRadioMAtualizar" class="genero2">
                    <input type="radio" id="inlineRadioMAtualizar" name="inlineRadioOptions" value="M" required <c:if test="${cliente.genero eq 'M'}">checked</c:if>>M</label>
                    <label for="unidadeAtualizar" class="form-label unidade">Unidade</label>
                    <select class="form-control" id="unidadeAtualizar" name="unidadeClienteAtualizar">
                        <c:if test="${not empty listaUnidades}">
                            <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                                <option value="${unidade.idUnidade}" <c:if test="${cliente.idUnidade == unidade.idUnidade}">selected</c:if> >${unidade.nome}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                    <button  class="btn btn-success" id="concluirAtualizar">Concluir</button>
                </form>
            </div>
        </c:if>
    </div>
    
    <div id="vendas" class="oculto">
        <c:if test='${etapa == "listarProdutosAVenda"}'>
            <div id="listarProdutosVenda" class="listarProdutosVenda">
                <br>
                <br>
                <h3>Produtos Disponíveis para Venda:</h3>
                <form action="CriarCarrinhoServlet" method="post">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Idioma</th>
                                <th>Módulo</th>
                                <th>Valor</th>
                                <th>Quantidade Disponível</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaProdutoVenda}" var="produto">
                                <tr>
                                    <td><c:out value="${produto.nomeProduto}" /></td>
                                    <td><c:out value="${produto.idiomaProduto}" /></td>
                                    <td><c:out value="${produto.moduloProduto}" /></td>
                                    <td><c:out value="${produto.valorProduto}" /></td>
                                    <td><c:out value="${produto.quantidadeProduto}" /></td>
                                    <td>
                                        <input type="number"  min="0" max="${produto.quantidadeProduto}" 
                                               name="quantidade${produto.idProduto}" value="0" required>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <input type="text" class="form-control" id="cpfCliente" placeholder="CPF do Cliente" name="cpfCliente" required>
                    <input type="submit" class="btn btn-success" id="btnComprar" value="Comprar">
                </form>
            </div>
            
        </c:if>
        
        <c:if test='${etapa == "carrinho"}'>
            <div id="listarProdutosPedidos" class="listarProdutosPedidos">
                <br>
                <br>
                <h3>Produtos Requeridos:</h3>
                <form action="RealizarCompraServlet" method="post">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Idioma</th>
                                <th>Módulo</th>
                                <th>Valor</th>
                                <th>Quantidade Solicitada</th>
                                <th>Valor da Quantidade</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="0" />
                            <c:forEach items="${listaProdutosPedidos}" var="produto">
                                <tr>
                                    <td><c:out value="${produto.nomeProduto}" /></td>
                                    <td><c:out value="${produto.idiomaProduto}" /></td>
                                    <td><c:out value="${produto.moduloProduto}" /></td>
                                    <td><c:out value="${produto.valorProduto}" /></td>
                                    <td><c:out value="${produto.quantidadeProduto}" /></td>
                                    <td><c:out value="${produto.valorProduto * produto.quantidadeProduto}"></c:out></td>
                                    <td>
                                        <input type="hidden" name="quantidade${produto.idProduto}" value="${produto.quantidadeProduto}" >
                                    </td>
                                    <td>
                                        <input type="hidden" name="valor${produto.idProduto}" value="${produto.valorProduto * produto.quantidadeProduto}" >
                                    </td>
                                </tr>
                                <c:set var="total" value="${total + produto.valorProduto * produto.quantidadeProduto}" />
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="6">Total: <c:out value="${total}"/></td>
                            </tr>
                        </tfoot>
                    </table>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome do Cliente:</th>
                                <th>CPF:</th>
                            </tr>    
                        </thead>
                        <tbody>
                            <tr>
                                <td><c:out value="${cliente.nome}" /></td>
                                <td><c:out value="${cliente.cpf}" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="${cliente.idPessoa}" name="idCliente">
                    <input type="submit" class="btn btn-success" id="btnComprar" value="Confirmar Compra">
                </form>
            </div>
        </c:if>
        
        <c:if test='${etapa == "clienteNEncontrado"}'>
            <h3>CPF não cadastrado: <c:out value="${cpfNEncontrado}"/></h3>
        </c:if>
            
        <c:if test='${etapa == "compraRealizada"}'>
            <h3>Compra realizada com sucesso</h3>
        </c:if>

    </div>
    
    <div id="gerenciamento" class="gerenciamento oculto">
        <div class="btn-group-vertical" role="group" id="botoesGerenciamento">
            <div id="btnFuncionario" class="btn btn-primary">Funcionarios</div>
            <div id="btnCurso" class="btn btn-info">Curso</div>
            <a id="btnProdutos" class="btn btn-primary" href="ListarProdutosServlet">Produtos</a>
            <div id="btnUnidade" class="btn btn-info">Unidades</div>
            <div id="btnRelatorios" class="btn btn-primary">Relatorios</div>
        </div>
        
        <div id="relatorios" class="relatorios oculto">
            <div class="botoesDeGerencia">
                <ul class="nav nav-pills nav-justified">
                  <li role="presentation" class="active"><a href="#">Data de Inicio</a></li>
                  <li role="presentation"><a href="#">Data de Fim</a></li>
                  <li role="presentation"><a href="#">Unidade</a></li>
                  <li role="presentation"><a href="#">Curso</a></li>
                  <li role="presentation"><a href="#">Modulo</a></li>
                </ul>
            </div>
        </div>
        
        <div id="produtos" class="produtos oculto">
            <div class="btn-group-vertical" role="group" id="botoesProduto">
                <div id="btnCadastroProduto" class="btn btn-info">Cadastrar Produtos</div>
            </div>
            
            <div id="listarProdutos" class="listarProdutos oculto">
                    <h3>Produtos Cadastrados:</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Idioma</th>
                                <th>Módulo</th>
                                <th>Valor</th>
                                <th>Quantidade</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaProduto}" var="produto">
                                <tr>
                                    <td><c:out value="${produto.nomeProduto}" /></td>
                                    <td><c:out value="${produto.idiomaProduto}" /></td>
                                    <td><c:out value="${produto.moduloProduto}" /></td>
                                    <td><c:out value="${produto.valorProduto}" /></td>
                                    <td><c:out value="${produto.quantidadeProduto}" /></td>
                                    <td>
                                        <form action="AlterarQuantidadeProduto" method="POST" id="alterarQuantProd">
                                            <input type="hidden" value="${produto.idProduto}" name="idProduto">
                                            <input type="text" id="inputNovaQuantidadeProd" class="form-control" placeholder="Nova Quantidade" name="novaQuantidadeProduto" required>
                                            <input type="submit" class="btn btn-success" id="alterarQuantidade" value="Salvar">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
            
            <div  id="cadastrarProduto" class="cadastrarProduto oculto">
                <form  id="controle" action="IncluirProdutoServlet" method="post">
                    <label for="inputNomeProduto" class="form-label">Nome do produto</label>
                    <input type="text" id="inputNomeProduto" class="form-control" placeholder="Nome" name="nome" required>
                    <label for="inputIdioma" class="form-label">Idioma do Produto</label>
                    <input id="inputIdioma" placeholder="Idioma" class="form-control" name="idioma" required>
                    <label for="moduloProduto"class="form-label">Modulo do Produto</label>
                    <input id="moduloModulo" placeholder="Módulo" class="form-control" name="modulo">
                    <label for="inputPreco" class="form-label">Preco</label>
                    <input type="text" id="inputPreco" class="form-control" placeholder="Preço" name="valor" required >
                    <label for="inputQuantidade" class="form-label">Quantidade</label>
                    <input type="text" id="inputQuantidade" class="form-control" placeholder="Quantidade" name="quantidade" required >
                    <input type="submit" class="btn btn-success" id="concluir" value="Concluir">
                </form> 
            </div>
        </div>
        
        
     <div id="pesquisaFuncionario" class="pesquisa  oculto" >
         <div id="campo">
            <form class="navbar-form navbar-left " role="search" >
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Nome funcionário " id="nomeFuncionario" name="nomeFuncionario" >
            </div>
            <button formaction="ListarFuncionariosServlet" formmethod="POST" id="btnFuncionarioPesquisa" class="btn btn-default glyphicon glyphicon-search"></button>
            <div id="btnNovoFuncionario" class="btn btn-primary">Novo</div>
            </form>
         </div>
      
        <div id="cadastrarFuncionario" class="cadastrarFuncionario oculto">
            <form  id="controle" action="IncluirFuncionarioServlet" method="POST">
                <label for="inputNomeFuncionario" class="form-label">Nome completo</label>
                <input type="text" id="inputNomeFuncionario" class="form-control" placeholder="nome completo" name="nomeFuncionario" required>
                <label for="inputNscimentoFuncionario" class="form-label" > Data de nascimento</label>
                <input type="date" id="inputNascimentoFuncionario"  class="form-control" name="dtNascimento" required>
                <label for="inputEnderecoFuncionario" class="form-label" >Endereco</label>
                <input type="text" id="inputEnderecoFuncionario" class="form-control"  placeholder="Endereco" name="enderecoFuncionario" required >
                <label for="inputCPFFuncionario" class="form-label">CPF</label>
                <input type="tel" id="inputCPFFuncionario"  class="form-control" placeholder="CPF" name="cpfFuncionario" maxlength="11" required >
                <label for="inputRGFuncionario" class="form-label">RG</label>
                <input type="tel" id="inputRGFuncionario"  class="form-control" placeholder="RG" name="rgFuncionario" maxlength="9" required >
                <h4 class="genero">Genero</h4>
                <label for="inputGeneroFuncionario" class="genero">   
                <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required>F</label>
                <label for="inputGenero" class="genero2">
                <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required >M</label>
                <label for="inputCargoFuncionario" class="form-label" id="cargo">Cargo</label>
                <input type="text" id="inputCargoFuncionario"  class="form-control" placeholder="Cargo" name="cargoFuncionario" required >
                <label for="unidade" class="form-label unidade">Unidade</label>
                    <select class="form-control" id="unidade" name="unidadeFuncionario">
                        <c:if test="${not empty listaUnidades}">
                            <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                                <option value="${unidade.idUnidade}">${unidade.nome}</option>
                            </c:forEach>
                        </c:if>
                    </select>   
                <label for="inputLoginFuncionario" class="form-label">Login</label>
                <input type="text" id="inputLoginFuncionario"  class="form-control" placeholder="Login" name="loginFuncionario" required >
                <label for="inputSenhaFuncionario" class="form-label">Senha</label>
                <input type="password" id="inputSenhaFuncionario"  class="form-control" placeholder="Senha" name="senhaFuncionario" required >
                <input type="submit" class="btn btn-success" id="concluir" value="Concluir">
            </form> 
        </div>
        <div id="listarFuncionario" class="oculto">
            <c:if test="${not empty listaFuncionario}">
            <table class="table table-striped">
                <tr class="tabelaInicio">
                    <td>Nome</td>
                    <td>Cargo</td>
                    <td> </td>
                </tr>
                <c:forEach items="${listaFuncionario}" var="funcionario" varStatus="stat">
                    <tr>
                    <form>
                        <input type="hidden" name="idFuncionario" value="${funcionario.idPessoa}">
                        <td><c:out value="${funcionario.nome}" /></td>
                        <td><c:out value="${funcionario.cargo}" /></td>
                        <td> 
                            <button id="btnFuncionarioAtualizaID" class="btn btn-info btnAtualiza" formmethod="GET" formaction="AlteraDadosFuncionarioServlet" >Atualizar</button> 
                            <button  formmethod="POST" formaction="removerFuncionarioServlet" class="btn btn-danger glyphicon glyphicon-trash" id="remover"></button>
                    </td>
                    </form>
                </tr>
                </c:forEach>
            </table>
            </c:if>
            <c:if test="${empty listaFuncionario}">
                <div class="aviso">Não foi encontrado nenhum resultados funcionario.</div>
            </c:if>
        </div> 
    </div> 
     
        
    <div id="pesquisaUnidade" class="pesquisa oculto" >
        <div id="campo">
            <form class="navbar-form navbar-left " role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Cidade" id="nomeCidade" name="cidadeUnidade" >
            </div>
            <button formaction="ListarUnidadeServlet" formmethod="POST" id="btnUnidadePesquisa" class="btn btn-default glyphicon glyphicon-search"></button>
            <div id="btnNovaUnidade" class="btn btn-primary">Novo</div>
            </form>
        </div>
        
        <div id="cadastrarUnidade" class="cadastrarUnidade oculto">
            <form  id="controle" action="IncluirUnidadeServlet" method="post">
                <label for="inputNomeUnidade" class="form-label">Nome da Unidade</label>
                <input type="text" id="inputNomeUnidade" class="form-control" placeholder="nome da unidade" name="nomeUnidade" required>
                <label for="inputEnderecoUnidade" class="form-label">Endereco da Unidade</label>
                <input id="inputEnderecoUnidade" placeholder="endereco" class="form-control" name="enderecoUnidade" required>
                <label for="inputCidadeUnidade"class="form-label">Cidade da Unidade</label>
                <input id="inputCidadeUnidade" placeholder="nome da cidade" class="form-control" name="cidadeUnidade">
                <input type="submit" class="btn btn-success" id="concluir" value="Concluir">
            </form> 
        </div>
        
        <div id="listarUnidade" class="oculto">
            <c:if test="${not empty listaUnidade}">
            <table class="table table-striped">
                <tr class="tabelaInicio">
                    <td>Nome</td>
                    <td>Endereço</td>
                    <td> </td>
                </tr>
                <c:forEach items="${listaUnidade}" var="unidade" varStatus="stat">
                    <tr>
                    <form>
                        <input type="hidden" value="${unidade.idUnidade}" name="idUnidade">
                        <td><c:out value="${unidade.nome}" /></td>
                        <td><c:out value="${unidade.endereco}" /></td>
                        <td>
                            <button id="btnUnidadeAtualizaID" class="btn btn-info btnAtualiza" formaction="AlterarDadosUnidadeServlet" formmethod="GET">Atualizar</button>
                            <button  class="btn btn-danger glyphicon glyphicon-trash" id="remover" formaction="removerUnidadeServlet" formmethod="POST"></button>
                        </td>
                    </form>
                </tr>
                </c:forEach>
            </table>
            </c:if>
            <c:if test="${empty listaUnidade}">
                <div class="aviso">Não foi encontrado nenhum resultados unidade.</div>
            </c:if>
        </div>
    </div>
        <!--parte nova  -->
    
    
    <div id="pesquisaCurso" class="pesquisa  oculto" >
        <div id="campo">
            <form class="navbar-form navbar-left " role="search" >
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Nome Curso" id="nomeCurso" name="nomeCurso" >
            </div>
            <button formaction="ListarCursosServlet" formmethod="POST" id="btnCursoPesquisa" class="btn btn-default glyphicon glyphicon-search"></button>
            <div id="btnNovoCurso" class="btn btn-primary">Novo</div>
            </form>
         </div>
        <div id="cadastrarCurso" class="cadastrarCurso oculto">
            <form  id="controle" action="IncluirCursoServlet" method="POST">
                <label for="inputNomeCurso" class="form-label">Nome Curso</label>
                <input type="text" id="inputNomeCurso" class="form-control" placeholder="curso" name="nomeCurso" required>
                <label for="inputModuloCurso" class="form-label">Módulo</label>
                <input id="inputIdioma" placeholder="moduloCurso" class="form-control" name="moduloCurso" required>
                <label for="inputSala"class="form-label">Sala</label>
                <input id="moduloModulo" placeholder="sala" class="form-control" name="salaCurso">
                <label for="inputValor" class="form-label">Valor</label>
                <input type="text" id="inputValor" class="form-control" placeholder="valor" name="valor" required >
                <label for="inputVagas" class="form-label">Vagas</label>
                <input type="text" id="inputVagas" class="form-control" placeholder="vagas" name="vagas" required >
                <label for="unidade" class="form-label unidade">Unidade</label>
                    <select class="form-control" id="unidade" name="unidade">
                        <option value="1">Rio de Janeiro</option>
                        <option value="2">Belo Horizonte </option>
                        <option value="3">Curitiba</option>
                        <option value="4">Porto Alegre</option>
                        <option value="5">Florianopolis</option>
                        <option value="6">Salvador</option>
                        <option value="7">Recife</option>
                        <option value="8">Goiania</option>
                        <option value="9">Manaus</option>
                        <option value="10">Belem</option>
                        <option value="11">Brasilia</option>
                    </select>
                <label for="periodo" class="form-label unidade">Periodo</label>
                    <select class="form-control" id="periodo" name="periodo">
                        <option value="1">Manha 9h30</option>
                        <option value="2">Manha 11h30</option>
                        <option value="3">Tarde 2h45</option>
                        <option value="4">Tarde 4h50</option>
                        <option value="5">Noite 18h</option>
                        <option value="6">Noite 20h</option>
                    </select>
                <input type="submit" class="btn btn-success" id="concluir" value="Concluir">
            </form> 
        </div>
        <div id="listarCurso" class="oculto">
            <c:if test="${not empty listaCurso}">
            <table class="table table-striped">
                <tr class="tabelaInicio">
                    <td>Identificação</td>
                    <td>Curso</td>
                    <td> </td>
                </tr>
                <c:forEach items="${listaCurso}" var="curso" varStatus="stat">
                    <tr>
                        <form>
                            <td><c:out value="${curso.idCurso}" /></td>
                            <td><c:out value="${curso.nomeCurso}" /></td>
                            <td>
                                <button id="btnFuncionarioAtualizaID" class="btn btn-info btnAtualiza" >Atualizar</button>
                                <button id="remover" class="btn btn-danger glyphicon glyphicon-trash" ></button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
            </c:if>
            <c:if test="${empty listaFuncionario}">
                <div class="aviso">Não foi encontrado nenhum resultados funcionario.</div>
            </c:if>
        </div> 
    </div>    
        
    
    <script src="js/telaPrincipal.js"></script>
    <c:if test='${paginaAtual == "produtos"}'>
        <script>
            mudarOcultoGerenciamento();
            mudarOcultoProdutos();
        </script>
    </c:if>
    <c:if test='${paginaAtual == "venda"}'>
        <script>
            mudarOcultoVendas();
        </script>
    </c:if>
    <c:if test="${clickBtnAtualizarCliente}">
        <script>
            mudarOcultoAtualizarCliente();
        </script>
    </c:if>    
    <c:if test="${clickBtnListaMatricula}">
        <script>
            mudarOcultoSelecionaCurso();
        </script>
    </c:if>
   </div>
</body>
</html>