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
 * @author Claudia Tejos
 */
@WebServlet(name = "AlterarDadosUnidadeServlet", urlPatterns = {"/AlterarDadosUnidadeServlet"})
public class AlterarDadosUnidadeServlet extends HttpServlet {

    public void alteraDadosUnidade(int idUnidade, Unidade unidade ){

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE `Unidade` SET `nomeUnidade` = ?, `enderecoUnidade` = ?,"
                + "`cidade` = ? WHERE `idUnidade` = ?";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, unidade.getNome());
            stmt.setString(2, unidade.getEndereco());
            stmt.setString(3, unidade.getCidade());
            stmt.setInt(4, idUnidade);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarDadosUnidadeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnMysql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnMysql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

    
    public Unidade pesquisarUnidade (int idUnidade){
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        Unidade unidade = null;
        
        String sql = "SELECT * FROM `Unidade` WHERE `idUnidade` LIKE '%"+idUnidade+"%'";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            
            if (resultados != null) {
                while (resultados.next()){
                    unidade = new Unidade(resultados.getInt("idUnidade"),
                            resultados.getString("nomeUnidade"),
                            resultados.getString("enderecoUnidade"),
                            resultados.getString("cidade")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlterarDadosUnidadeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnMysql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnMysql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return unidade;
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
        
         int idUnidade= Integer.parseInt(request.getParameter("idUnidade")); 
         
        request.setAttribute("unidade", pesquisarUnidade(idUnidade));

        RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/editarFornecedor.jsp");
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
        
        int idUnidade= Integer.parseInt(request.getParameter("idUnidade")); 
        String nome = request.getParameter("nomeUnidade");
        String endereco = request.getParameter("enderecoUnidade");
        String cidade = request.getParameter("cidadeUnidade");

        Unidade unidade = new Unidade(nome, endereco, cidade);
        alteraDadosUnidade(idUnidade,unidade);
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
