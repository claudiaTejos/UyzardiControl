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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Claudio
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
        
        String login = request.getParameter("inputEmail");
        String senha = request.getParameter("inputPassword");
        Funcionario funcionario = buscarFuncionario(login);

    
        //Testa se o login e senha está correto com o do banco e avança de tela
        if (funcionario != null && funcionario.autenticar(login, senha)){
            ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
            request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
            request.setAttribute("emailFuncionario", login);
            
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
              // Força invalidação da sessão anterior.
              sessao.invalidate();
            }
            sessao = request.getSession(true);
            sessao.setAttribute("funcionario", funcionario);
            sessao.setAttribute("unidade", buscarUnidade(funcionario.getUnidade()));
                
            RequestDispatcher rd = request.getRequestDispatcher("telaPrincipal.jsp");
            rd.forward(request, response);
        }
        //Retorna erro para o jsp
        else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("lblErro", "Usuário e/ou senha inválidos");
            rd.forward(request, response);
        }
        
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
    
    public Funcionario buscarFuncionario(String email) {
        PreparedStatement stmt = null;
        Connection conn = null;
    
        String sql = "SELECT * FROM `Funcionario` WHERE LOWER( `login` ) = LOWER( ? )";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()) {
                int idFuncionario = resultado.getInt("idFuncionario");
                String nomeFuncionario = resultado.getString("nomeFuncionario");
                long cpfFuncionario = resultado.getLong("cpfFuncionario");
                int rgFuncionario = resultado.getInt("rgFuncionario");
                String endFuncionario = resultado.getString("endFuncionario");
                char generoFuncionario = resultado.getString("generoFuncionario").charAt(0);
                Date dataNascFuncionario = resultado.getDate("dataNascFuncionario");
                int idUnidade = resultado.getInt("idUnidade");
                String login = resultado.getString("login");
                String senha = resultado.getString("senha");
                String cargo = resultado.getString("cargo");
                Funcionario funcionario = new Funcionario(
                        idFuncionario, nomeFuncionario, cpfFuncionario, 
                        rgFuncionario, endFuncionario, dataNascFuncionario, 
                        generoFuncionario, cargo, idUnidade, login, senha);
                return funcionario;
            } else {	                                       
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    
    public Unidade buscarUnidade (int idUnidade){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM Unidade WHERE `idUnidade` = ?";

        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUnidade);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()) {
                Unidade unidade = new Unidade(resultado.getInt("idUnidade"),
                            resultado.getString("nomeUnidade"),
                            resultado.getString("enderecoUnidade"),
                            resultado.getString("cidade")
                    );
                return unidade;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    };

}
