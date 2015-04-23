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
import java.sql.Statement;
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
 * @author Claudia
 */
@WebServlet(name = "IncluirAlunoServlet", urlPatterns = {"/IncluirAlunoServlet"})
public class IncluirAlunoServlet extends HttpServlet {

    private void incluirAluno(Cliente aluno){
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
            stmt.setString(2, aluno.getNome());
            stmt.setDate(3, new java.sql.Date(aluno.getDtNasc().getTime()));
            stmt.setObject(4,(char)aluno.getGenero());
            stmt.setString(5, aluno.getEndereco());
            stmt.setInt(6, aluno.getCpf());
            stmt.setInt(7, aluno.getRg());
            stmt.executeUpdate();
            System.out.println("Incluido com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(IncluirAlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IncluirAlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirAlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirAlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(IncluirAlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            dtNascimento = null;
        }
        char generoAluno = genero.charAt(0);
        int cpfAluno = Integer.parseInt(cpf);
        int rgAluno = Integer.parseInt(rg);
        
        Cliente aluno = new Cliente(nome,cpfAluno, rgAluno,endereco,dtNascimento, generoAluno);
        
        
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
