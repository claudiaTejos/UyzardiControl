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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ListarProdutosVenda", urlPatterns = {"/ListarProdutosVenda"})
public class ListarProdutosVendaServlet extends HttpServlet {

    private ArrayList<Produto> listaProdutoVenda;
    
    private void listarProdutosVenda(){
        
        Statement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM `Produto` WHERE `quantidade` > 0";
        listaProdutoVenda = new ArrayList();
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet resultados = stmt.executeQuery(sql);
            while (resultados.next()){
                Produto produto = new Produto(resultados.getInt("idProduto"),
                        resultados.getString("nomeProduto"),
                        resultados.getString("idiomaProduto"),
                        resultados.getString("moduloProduto"),
                        resultados.getDouble("valorProduto"),
                        resultados.getInt("quantidade")
                        );
                listaProdutoVenda.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        listarProdutosVenda();
        request.setAttribute("listaProdutoVenda", listaProdutoVenda);

        request.setAttribute("paginaAtual", "venda");
        request.setAttribute("etapa", "listarProdutosAVenda");
        RequestDispatcher rd = request.getRequestDispatcher("telaPrincipal.jsp");
        
        rd.forward(request, response);
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
