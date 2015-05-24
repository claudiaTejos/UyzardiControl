/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uyzardi;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * http://www.journaldev.com/1933/java-servlet-filter-example-tutorial
 */
@WebFilter(filterName = "AutorizacaoFilter", urlPatterns = {"*.jsp"}, 
        servletNames = {
            "AlteraDadosFuncionarioServlet", 
            "AlterarDadosUnidadeServlet",
            "AlterarQuantidadeProduto",
            "atualizarCliente",
            "CriarCarrinhoServlet",
            "desativarMatricula",
            "incluirCliente",
            "IncluirCursoServlet",
            "IncluirFuncionarioServlet",
            "incluirMatricula",
            "IncluirProdutoServlet",
            "IncluirUnidadeServlet",
            "listaMatricula",
            "ListarCursosServlet",
            "ListarFuncionariosServlet",
            "ListarProdutosServlet",
            "ListarProdutosVenda",
            "ListarUnidadeServlet",
            "pesquisarCliente",
            "RealizarCompraServlet",
            "selecionaCliente",
            "removerFuncionarioServlet",
            "removerUnidadeServlet" 
        })
public class AutorizacaoFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {

    // 1) OBTEM AS INFORMACOES DO USUARIO DA SESSAO
    // A) CAST DOS PARÂMETROS RECEBIDOS
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    // B) TENTA RECUPERAR A SESSÃO DO USUÁRIO
    HttpSession sessao = httpRequest.getSession();
    Funcionario usuario = (Funcionario) sessao.getAttribute("funcionario");

    // 2) NA LÓGICA IMPLEMENTADA, SE EXISTIR OBJETO DO USUÁRIO SIGNIFICA
    //    QUE USUÁRIO ESTÁ LOGADO
    //    CASO CONTRÁRIO, REDIRECIONA PARA TELA DE LOGIN
    if (usuario == null) {
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      rd.forward(request, response);
      return;
    }

    try {
        chain.doFilter(request, response);
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

  /**
   * ROTINA PARA DESTRUIÇÃO DO FILTRO
   */
  @Override
  public void destroy() {
  }

  /**
   * ROTINA DE INICIALIZAÇÃO DO FILTRO
   */
  @Override
  public void init(FilterConfig filterConfig) {
  }

}
