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
import java.sql.Statement;
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
 * @author Claudia
 */
@WebServlet(name = "incluirCliente", urlPatterns = {"/incluirCliente"})
public class IncluirClienteServlet extends HttpServlet {

    private boolean incluirCliente(Cliente cliente){
        boolean controle = false;
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO `Cliente`"
                + "(nomeCliente, dataNascimentoCliente,"
                + "sexoCliente,enderecoCliente, cpfCliente, rgCliente, idUnidade) VALUES"
                + "(?,?,?,?,?,?,?)";
        
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setDate(2, new java.sql.Date(cliente.getDtNasc().getTime()));
            stmt.setObject(3, cliente.getGenero(), java.sql.Types.VARCHAR);
            stmt.setString(4, cliente.getEndereco());
            stmt.setLong(5, cliente.getCpf());
            stmt.setInt(6, cliente.getRg());
            stmt.setInt(7, cliente.getIdUnidade());
            stmt.executeUpdate();
            controle = true;
            
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
            out.println("<title>Servlet IncluirAlunoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IncluirAlunoServlet at " + request.getContextPath() + "</h1>");
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

        String nome = request.getParameter("nomeAlunoIncluir");
        String dtNasc = request.getParameter("dt_Nascimento");
        char generoCliente = request.getParameter("inlineRadioOptions").charAt(0);
        String endereco = request.getParameter("endereco");
        long cpfCliente = Long.parseLong(request.getParameter("cpf"));
        int rgCliente = Integer.parseInt(request.getParameter("rg"));
        int unidade = Integer.parseInt(request.getParameter("unidadeCliente"));
        Date dtNascimento = null;
        
        DateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dtNascimento = formatadorData.parse(dtNasc);
        } catch (ParseException ex) {
            Logger.getLogger(IncluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Cliente cliente = new Cliente(nome, cpfCliente, rgCliente, endereco, dtNascimento, generoCliente, unidade);
        
        if (incluirCliente(cliente)) {
            request.setAttribute("resultadoIncluir", true);
            request.setAttribute("cliente", cliente);
        }
        else{
            request.setAttribute("resultadoIncluir", false);
        }
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
