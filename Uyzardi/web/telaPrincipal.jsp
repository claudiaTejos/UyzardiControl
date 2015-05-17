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
                        <tr>
                            <td><c:out value="${cliente.idPessoa}" /></td>
                            <td><c:out value="${cliente.nome}" /></td>
                            <td>
                                <a id="btnAlunoAtualizaID${cliente.idPessoa}" class="btn btn-info btnAtualiza">Atualizar</a> 
                                <button id="btnMatriculaID" value="${cliente.idPessoa}" name="idAlunoMatricula" class="btn btn-info" formmethod="POST" formaction="listaMatricula">Matricula</button>
                            </td>
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
                <button  class="btn btn-success" id="concluir" formaction="incluirCliente" formmethod="POST">Concluir</button>
            </form>
        </div>
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
                                        </input>
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
                <form action="RealizarCompraServlet" method="post">
                    <input type="submit" class="btn btn-success" id="btnComprar" value="Confirmar Compra">
                </form>
            </div>
            
            
        </c:if>
        
        
        
        <div class="produto">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control" id="pesquisar" placeholder="Nome do Aluno" name="pesquisarNomeAluno">
                </div>
                <div class="btn btn-primary" id="btnPesquisarAluno"> Pesquisa</div>
            </form> 
        </div>
        
        <div class="PesquisaAlunos">
            <table class="table table-striped">
                <tr class="Produtos">
                    <td>Nome</td>
                    <td>Matricula</td>
                    <td> </td>
                </tr>
                <tr>
                    <td>Jena</td>
                    <td>Jane</td>
                    <td>
                        <div class="btn btn-info">Atualizar</div>
                        <div class="btn btn-default">Selecionar</div>
                    </td>
                </tr>
            </table>
        </div>
        
        <form>
            <div>
                <button id="btnAdicao" type="button" class="btn btn-default" aria-label="Left Align">
                <span  class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </button>
                <div>
                    <table class="table table-striped">
                        <tr class="Produtos">
                            <td>Produto</td>
                            <td>Qtde</td>
                            <td>Valor</td>
                        </tr>
                        <tr>
                            <td>Livro</td>
                            <td> 1</td>
                            <td>5,90</td>
                        </tr>
                    </table>
                </div>
            </div>
        
            <div class="total">
                <label >Total</label>
                <label >R$ 5,90</label>
            </div>
        
            <div class="total">
                <button class="btn btn-success">Finalizar</button>
            </div>
        </form>
        
        <div>
            <div>
                <table class="table table-striped">
                    <tr class="Produtos">
                     <td>Nome</td>
                    <td>Descricao</td>
                    <td> </td>
                 </tr>
                 <tr>
                    <td>Livro</td>
                    <td>informacoes sobre o livro</td>
                    <td>
                    <div class="btn btn-default">Selecionar</div>
                    </td>
                </tr>
               </table>
            </div> 
        </div>  
    </div>
    
    <div id="gerenciamento" class="gerenciamento oculto">
        <div class="btn-group-vertical" role="group" id="botoesGerenciamento">
        <div id="btnFuncionario" class="btn btn-primary">Funcionario</div>
        <a id="btnProdutos" class="btn btn-info" href="ListarProdutosServlet">Produtos</a>
        <div id="btnUnidade" class="btn btn-primary">Unidades</div>
        <div id="btnRelatorios" class="btn btn-info">Relatorios</div>
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
                <input type="text" id="inputCPFFuncionario"  class="form-control" placeholder="CPF" name="cpfFuncionario" required >
                <label for="inputRGFuncionario" class="form-label">RG</label>
                <input type="text" id="inputRGFuncionario"  class="form-control" placeholder="RG" name="rgFuncionario" required >
                <h4 class="genero">Genero</h4>
                <label for="inputGeneroFuncionario" class="genero">   
                <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required>F</label>
                <label for="inputGenero" class="genero2">
                <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required >M</label>
                <label for="inputCargoFuncionario" class="form-label" id="cargo">Cargo</label>
                <input type="text" id="inputCargoFuncionario"  class="form-control" placeholder="Cargo" name="cargoFuncionario" required >
                <label for="unidade" class="form-label unidade">Unidade</label>
                    <select class="form-control" id="unidade" name="unidadeFuncionario">
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
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td><c:out value="${funcionario.cargo}" /></td>
                    <td>
                        <button id="btnFuncionarioAtualizaID${funcionario.idPessoa}" class="btn btn-info btnAtualiza">Atualizar</button> 
                        <button id="btnRemoverFuncionarioID" value="${funcionario.idPessoa}" name="idRemoverFuncionario" class="btn btn-danger glyphicon glyphicon-trash " formmethod="POST" formaction="listaMatricula"></button>
                    </td>
                </tr>
                </c:forEach>
            </table>
            </c:if>
            <c:if test="${empty listaFuncionario}">
                <div class="aviso">Não foi encontrado nenhum resultados funcionario.</div>
            </c:if>
        </div> 
    </div> 
     
        
    <div id="pesquisaUnidade" class="pesquisa  oculto" >
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
                    <td><c:out value="${unidade.nome}" /></td>
                    <td><c:out value="${unidade.endereco}" /></td>
                    <td>
                        <button id="btnUnidadeAtualizaID${unidade.idUnidade}" class="btn btn-info btnAtualiza">Atualizar</button> 
                        <button id="btnRemoverUnidadeID" value="${unidade.idUnidade}" name="idRemoverUnidade" class="btn btn-danger glyphicon glyphicon-trash " formmethod="POST" formaction="listaMatricula"></button>
                    </td>
                </tr>
                </c:forEach>
            </table>
            </c:if>
            <c:if test="${empty listaUnidade}">
                <div class="aviso">Não foi encontrado nenhum resultados unidade.</div>
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
        
    </div>
</body>
</html>