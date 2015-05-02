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
	<div class="empresa"><h1>Uizardy Control</h1></div>
    <div class="menu-geral">
    	<ul class="nav nav-pills nav-justified">
            <li><a id="btnMatricula">Matricula</a></li>
            <li><a id="btnVendas">Vendas</a></li>
            <li><a id="btnRelatorios">Gerenciamento</a></li>
            <li><a id="btnProdutos" href="PesquisarProdutosServlet">Produtos</a></li>
        </ul>
    </div>

    <div id="matricula" class="oculto">
        <div id="pesquisa" class="pesquisa">
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Nome aluno" id="nomeAluno">
              </div>
                <div formaction="PesquisarAluno" id="btnAlunoPesquisa" class="btn btn-default">Pesquisa</div>
              <div id="btnAlunoAtualiza" class="btn btn-info">Atualizar</div>
              <div id="btnAlunoNovo" class="btn btn-primary">Novo</div>
            </form>
        </div>

        <div id="listaAluno" class="alunos-na-lista oculto">
            <table class="table table-striped">
              <tr class="tabelaInicio">
                <td>Matricula</td>
                <td>Nome</td>
                <td>Ações</td>
              </tr>
              <c:forEach items="${listaAluno}" var="aluno" varStatus="stat">
                    <tr>
                        <td><c:out value="${aluno.idPessoa}" /></td>
                        <td><c:out value="${aluno.nome}" /></td>
                        <td></td>
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
        <!-- Parte nova-->
        <div class="produto">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control" id="pesquisa" placeholder="Nome do Aluno">
                </div>
                <div class="btn btn-default" id="btnPesquisarAluno"> Pesquisa</div>
            </form> 
        </div>
        
        <div class="PesuisaAlunos">
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
                <button type="button" class="btn btn-default" aria-label="Left Align">
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
        <!-- fim parte nova-->
    </div>
    
    <div id="relatorios" class="relatorios oculto">
        <div class="btn-group-vertical" role="group" id="botoesGerenciamento">
        <div id="btnCadastroFuncionario" class="btn btn-default">Cadastrar Funcionario</div>
        <div id="btnCadastroProduto" class="btn btn-info">Cadastrar Produtos</div>
        <div id="btnRelatórios" class="btn btn-primary">Relatorios</div>
        </div>
        
        
        <ul class="nav nav-tabs">
          <li role="presentation" class="active"><a href="#">Data de Inicio</a></li>
          <li role="presentation"><a href="#">Data de Fim</a></li>
          <li role="presentation"><a href="#">Unidade</a></li>
          <li role="presentation"><a href="#">Curso</a></li>
          <li role="presentation"><a href="#">Modulo</a></li>
        </ul>
        
        <!--parte nova  -->
    <div>
        <form id="dadosFuncionario">
            <label for="inputNomeFuncionario" class="form-label">Nome completo</label>
            <input type="text" id="inputNomeFuncionario" class="form-control" name="nomeFuncionario" required>
            <label for="inputNscimentoFuncionario" class="form-label" > Data de nascimento</label>
            <input type="date" id="inputNascimentoFuncionario"  class="form-control" name="dtNascimento" required>
            <label for="inputEnderecoFuncionario" class="form-label" >Endereco</label>
            <input type="text" id="inputEnderecoFuncionario" class="form-control"  placeholder="Endereco" name="enderecoFuncionario" required >
            <label for="inputCPFFuncionario" class="form-label">CPF</label>
            <input type="text" id="inputCPFFuncionario"  class="form-control" placeholder="CPF" name="cpfFuncionario" required >
            <label for="inputRGFuncionario" class="form-label">RG</label>
            <input type="text" id="inputRGFuncionario"  class="form-control" placeholder="RG" name="rg" required >
            <h4 class="genero">Genero</h4>
            <label for="inputGeneroFuncionario" class="genero">   
            <input type="radio" id="inlineRadioF" name="inlineRadioOptions" value="F" required>F</label>
            <label for="inputGenero" class="genero2">
            <input type="radio" id="inlineRadioM" name="inlineRadioOptions" value="M" required >M</label>
            <input type="submit" class="btn btn-success" id="concluir" value="Concluir">
        </form> 
    </div>
    
    
    <div>
        <form id="dadosProduto">
            <label for="inputNomeProduto" class="form-label">Nome do produto</label>
            <input type="text" id="inputNomeProduto" class="form-control" placeholder="nome do produto"name="nomeProduto" required>
            <label for="inputIdioma" class="form-label">Idioma do Produto</label>
            <input id="inputIdioma" placeholder="idioma" class="form-control" name="idiomaProduto" required>
            <label for="moduloProduto"class="form-label">Modulo do Produto</label>
            <input id="moduloModulo" placeholder="modulo do produto" class="form-control" name="moduloProduto">
            <label for="inputPreco" class="form-label">Preco</label>
            <input type="text" id="inputPreco" class="form-control" placeholder="preco" name="precoProduto" required >
            <input type="submit" class="btn btn-success" id="concluir" value="Concluir">
        </form> 
    </div>
    <!-- fim parte nova-->
    
    </div>
    <c:if test='${paginaAtual == "produtos"}'>
        <div id="produtos">
            <br>
            <br>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Idioma</th>
                        <th>Módulo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td><c:out value="${produto.nomeProduto}" /></td>
                        <td><c:out value="${produto.idiomaProduto}" /></td>
                        <td><c:out value="${produto.moduloProduto}" /></td>
                        <td><c:out value="${produto.valorProduto}" /></td>
                        <td></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
 
    <script src="js/telaPrincipal.js"></script>
</body>
</html>