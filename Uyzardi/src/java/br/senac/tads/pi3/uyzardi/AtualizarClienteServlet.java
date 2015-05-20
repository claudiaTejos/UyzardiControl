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
 * @author Claudio
 */
@WebServlet(name = "atualizarCliente", urlPatterns = {"/atualizarCliente"})
public class AtualizarClienteServlet extends HttpServlet {
    
    public boolean atualizarCliente (Cliente cliente){
        boolean controle = false;
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "UPDATE `Cliente` SET `nomeCliente` = ?,"
                + "`cpfCliente` = ?, `rgCliente` = ?, `endCliente` = ?,"
                + "`dataNascimento` = ?, `idUnidade` = ?, `generoCliente` = ? "
                + "WHERE `idCliente` = ?";
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setLong(2, cliente.getCpf());
            stmt.setInt(3, cliente.getRg());
            stmt.setString(4, cliente.getEndereco());
            stmt.setDate(5, new java.sql.Date(cliente.getDtNasc().getTime()));
            stmt.setInt(6, cliente.getIdUnidade());
            stmt.setObject(7, cliente.getGenero(), java.sql.Types.VARCHAR);
            stmt.setInt(8, cliente.getIdPessoa());
            stmt.executeQuery();
            controle = true;
        } catch (SQLException ex) {
            Logger.getLogger(AlteraDadosFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        
        return controle;
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
            out.println("<title>Servlet AtualizarClienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AtualizarClienteServlet at " + request.getContextPath() + "</h1>");
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
        Cliente cliente = PesquisarClienteServlet.pesquisaClienteID((int)request.getAttribute("btnAcoesHiddenIDCliente"));
        
        ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(request.getParameter("btnAcoesHiddenIDCliente")));
        request.setAttribute("clickBtnAtualizarCliente", "true");
        request.setAttribute("cliente", cliente);
        RequestDispatcher rd = request.getRequestDispatcher("telaPrincipal.jsp");
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
