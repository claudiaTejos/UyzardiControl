/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uyzardi;

import br.senac.tads.pi3.comum.ConnMysql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joana
 */
@WebServlet(name = "AlterarQuantidadeProduto", urlPatterns = {"/AlterarQuantidadeProduto"})
public class AlterarQuantidadeProduto extends HttpServlet {

    private void alterarQuantProd(int idProduto, int novaQuantidade){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "UPDATE `Produto` SET `quantidade` = ? WHERE `idProduto` = ?";
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(AlterarQuantidadeProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(AlterarQuantidadeProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            out.println("<title>Servlet AlterarQuantidadeProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarQuantidadeProduto at " + request.getContextPath() + "</h1>");
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
        
        
        String idProdutoString = request.getParameter("idProduto");
        String novaQuantidadeString = request.getParameter("novaQuantidadeProduto");
        
        int idProdutoInt = Integer.parseInt(idProdutoString);
        int novaQuantidadeInt = Integer.parseInt(novaQuantidadeString);
        
        alterarQuantProd(idProdutoInt, novaQuantidadeInt);
        
        request.setAttribute("confirmacao", "alteracao");
        request.setAttribute("paginaAtual", "produtos");
        RequestDispatcher rd = request.getRequestDispatcher("ListarProdutosServlet");
        rd.forward(request, response);
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
