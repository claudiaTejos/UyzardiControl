/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uyzardi;

import br.senac.tads.pi3.comum.ConexaoBDJavaDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.Logger;

/**
 *
 * @author joana.omsilva
 */
@WebServlet(name = "IncluirProdutoServlet", urlPatterns = {"/IncluirProdutoServlet"})
public class IncluirProdutoServlet extends HttpServlet {

    private void incluirProduto(Produto produto){
        
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("Uyzardi");
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO TB_PRODUTO"
                + "(NOMEPRODUTO, IDIOMAPRODUTO, "
                + "MODULOPRODUTO, VALORPRODUTO) VALUES "
                + "(?,?,?,?)";
        
        
        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, produto.getNomeProduto());
            stmt.setString(3, produto.getIdiomaProduto());
            stmt.setString(4, produto.getModuloProduto());
            stmt.setDouble(5, produto.getValorProduto());
            stmt.executeUpdate();
            System.out.println("Incluído com sucesso");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(IncluirProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IncluirProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IncluirProdutoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IncluirProdutoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nome = request.getParameter("nome");
        String idioma = request.getParameter("idioma");
        String modulo = request.getParameter("modulo");
        String valorString = request.getParameter("valor");
        
        double valorDouble = Double.parseDouble(valorString);
        
        Produto produto = new Produto(nome, idioma, modulo, valorDouble);
        
        incluirProduto(produto);
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
