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
 * @author joana.omsilva
 */
@WebServlet(name = "IncluirFuncionarioServlet", urlPatterns = {"/IncluirFuncionarioServlet"})
public class IncluirFuncionarioServlet extends HttpServlet {

    private void incluirFuncionario(Funcionario funcionario){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO `Funcionario`"
                + "(`nomeFuncionario`, `cpfFuncionario`,"
                + "`rgFuncionario`,`endFuncionario`,`generoFuncionario`, `dataNascFuncionario`,"
                + "`cargo`, `idUnidade`, `login`, `senha`, `Status`) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setLong(2,funcionario.getCpf());
            stmt.setInt(3,funcionario.getRg());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setObject(5,funcionario.getGenero(), java.sql.Types.VARCHAR);
            stmt.setDate(6, new java.sql.Date(funcionario.getDtNasc().getTime()));
            stmt.setString(7, funcionario.getCargo());
            stmt.setInt(8, funcionario.getUnidade());
            stmt.setString(9, funcionario.getLogin());
            stmt.setString(10, funcionario.getSenha());
            stmt.setObject(11, funcionario.getStatus(), java.sql.Types.VARCHAR);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IncluirFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            out.println("<title>Servlet IncluirFuncionarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IncluirFuncionarioServlet at " + request.getContextPath() + "</h1>");
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
        
        String nome = request.getParameter("nomeFuncionario");
        String dtNasc = request.getParameter("dtNascimento");
        char genero = request.getParameter("inlineRadioOptions").charAt(0);
        String endereco = request.getParameter("enderecoFuncionario");
        long cpf =  Long.parseLong(request.getParameter("cpfFuncionario"));
        int rg =  Integer.parseInt(request.getParameter("rgFuncionario"));
        String cargo = request.getParameter("cargoFuncionario");
        int unidade = Integer.parseInt(request.getParameter("unidadeFuncionario"));
        String login = request.getParameter("loginFuncionario");
        String senha = request.getParameter("senhaFuncionario");
        char status = request.getParameter("inlineRadioOptionsStatus").charAt(0);
        
        
        Date dtNascimento = null;
        
        DateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dtNascimento = formatadorData.parse(dtNasc);
        } catch (ParseException ex) {
            throw new RuntimeException(String.format("Data Inválida: %s",dtNasc), ex);
        }

        
        Funcionario funcionario = new Funcionario(nome, cpf, rg, endereco, dtNascimento,
                genero, cargo, unidade, login, senha, status);
        
        ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
        
        incluirFuncionario(funcionario);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionariosServlet");
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
