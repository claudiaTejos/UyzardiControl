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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "incluirMatricula", urlPatterns = {"/incluirMatricula"})
public class IncluirMatriculaServlet extends HttpServlet {
    
    public boolean incluirMatricula(Matricula novaMatricula){
        boolean resultado = false;
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO `Matricula`"
                + "(idCliente, idUnidade, idFuncionario, idCurso, "
                + "dataHoraMatricula, StatusMatricula) VALUES"
                + "(?,?,?,?,?,?)";
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, novaMatricula.getIdCliente());
            stmt.setInt(2, novaMatricula.getIdUnidade());
            stmt.setInt(3, novaMatricula.getIdFuncionario());
            stmt.setInt(4, novaMatricula.getIdCurso());
            stmt.setDate(5, new java.sql.Date(novaMatricula.getDataMatricula().getTime()));
            stmt.setString(6, novaMatricula.getStatusMatricula());
            
            
            stmt.executeUpdate();
            resultado = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(IncluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return resultado;
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
            out.println("<title>Servlet IncluirMatriculaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
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
        Funcionario f = (Funcionario)request.getSession().getAttribute("funcionario");
        int idFuncionario = f.getIdPessoa();
        int cliente = Integer.parseInt(request.getParameter("hiddenClienteMatricula"));
        int opcaoCurso = Integer.parseInt(request.getParameter("optionCurso"));
        int unidade = Integer.parseInt(request.getParameter("hiddenClienteUnidadeMatricula"));
        Date data = new Date();
        
        Matricula novaMatricula = new Matricula(cliente, data, idFuncionario, opcaoCurso, "A", unidade);
        
        if (incluirMatricula(novaMatricula)) {
            request.setAttribute("resultadoIncluirMatricula", true);
            request.setAttribute("matricula", novaMatricula);
        }
        else{
            request.setAttribute("resultadoIncluir", false);
        }

        request.setAttribute("confirmacao", "cadastro");
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
