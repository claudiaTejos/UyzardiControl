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
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cauê Camargo
 */
@WebServlet(name = "IncluirUnidadeServlet", urlPatterns = {"/IncluirUnidadeServlet"})
public class IncluirUnidadeServlet extends HttpServlet {

    private void incluirUnidade(Unidade unidade) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO `Unidade`"
                + "(`nomeUnidade`,`enderecoUnidade`, `cidade`, `Status`) VALUES"
                + "(?,?,?,?)";

        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, unidade.getNome());
            stmt.setString(2, unidade.getEndereco());
            stmt.setString(3, unidade.getCidade());
            stmt.setObject(4, unidade.getStatus(), java.sql.Types.VARCHAR);
            stmt.executeUpdate();
            System.out.println("Incluido com sucesso");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirUnidadeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirUnidadeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IncluirUnidadeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IncluirUnidadeServlet at " + request.getContextPath() + "</h1>");
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

        String nome = request.getParameter("nomeUnidade");
        String endereco = request.getParameter("enderecoUnidade");
        String cidade = request.getParameter("cidadeUnidade");
        char statusUnidade = request.getParameter("inlineRadioOptionsStatus").charAt(0);

        Unidade unidade = new Unidade(nome, endereco, cidade, statusUnidade);
        incluirUnidade(unidade);

        RequestDispatcher rd = request.getRequestDispatcher("ListarUnidadeServlet");
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
