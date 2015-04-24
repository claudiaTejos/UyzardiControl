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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("Uyzardi");
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO TB_PESSOA"
                + "(NOMEPESSOA, DATANASCIMENTO,"
                + "SEXO,ENDERECOPESSOA, CPF, RG) VALUES"
                + "(?,?,?,?,?,?)";
        
        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, funcionario.getNome());
            stmt.setDate(3, new java.sql.Date(funcionario.getDtNasc().getTime()));
            stmt.setObject(4,(char)funcionario.getGenero());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setInt(6, funcionario.getCpf());
            stmt.setInt(7, funcionario.getRg());
            stmt.executeUpdate();
            System.out.println("Incluido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(IncluirFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IncluirFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
        
        String nome = request.getParameter("nome");
        String dtNasc = request.getParameter("dt_Nascimento");
        String genero = request.getParameter("inlineRadioOptions");
        String endereco = request.getParameter("endereco");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        
        
        DateFormat formatadorData = new SimpleDateFormat ("dd/MM/yyyy");
        Date dtNascimento;
        try {
            dtNascimento = formatadorData.parse(dtNasc);
        } catch (ParseException ex) {
            Logger.getLogger(IncluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            dtNascimento = null;
        }
        char generoC = genero.charAt(0);
        int cpfI = Integer.parseInt(cpf);
        int rgI = Integer.parseInt(rg);
        
        Funcionario funcionario = new Funcionario(nome,cpfI, rgI,endereco,dtNascimento, generoC);
        
        incluirFuncionario(funcionario);
        
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
