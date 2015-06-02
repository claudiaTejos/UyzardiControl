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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author Claudia Tejos
 */
@WebServlet(name = "AlteraDadosFuncionarioServlet", urlPatterns = {"/AlteraDadosFuncionarioServlet"})
public class AlteraDadosFuncionarioServlet extends HttpServlet {
    
    public void alteraDadosFunc(int idFuncionario, Funcionario funcionario ){

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE `Funcionario` SET `nomeFuncionario` = ?, `cpfFuncionario` = ?,"
                + "`rgFuncionario` = ?, `endFuncionario` = ?, `dataNascFuncionario` = ?,"
                + "`generoFuncionario` = ?, `cargo` = ?, `idUnidade` = ?,"
                + "`login` = ?, `senha` = ? , `Status` = ? WHERE `idFuncionario` = ?";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setLong(2,funcionario.getCpf());
            stmt.setInt(3,funcionario.getRg());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setDate(5, new java.sql.Date(funcionario.getDtNasc().getTime()));
            stmt.setObject(6,funcionario.getGenero(), java.sql.Types.VARCHAR);
            stmt.setString(7, funcionario.getCargo());
            stmt.setInt(8, funcionario.getUnidade());
            stmt.setString(9, funcionario.getLogin());
            stmt.setString(10, funcionario.getSenha());
            stmt.setObject(11, funcionario.getStatus(), java.sql.Types.VARCHAR);
            stmt.setInt(12, idFuncionario);
            stmt.executeUpdate();
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
    }
    
    public Funcionario pesquisarFuncionario (int idFuncionario){
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null; 

        Funcionario funcionario = null;
        String sql = "SELECT * FROM `Funcionario` WHERE `idFuncionario` LIKE '%"+idFuncionario+"%'";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            
            if (resultados != null) {
                while (resultados.next()){
                    funcionario = new Funcionario(resultados.getInt("idFuncionario"),
                            resultados.getString("nomeFuncionario"),
                            resultados.getLong("cpfFuncionario"),
                            resultados.getInt("rgFuncionario"),
                            resultados.getString("endFuncionario"),
                            resultados.getDate("dataNascFuncionario"),
                            resultados.getString("generoFuncionario").charAt(0),
                            resultados.getString("cargo"),
                            resultados.getInt("idUnidade"),
                            resultados.getString("login"),
                            resultados.getString("senha"),
                            resultados.getString("Status").charAt(0));
                }
            }
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
        return funcionario;
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
        
        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
        request.setAttribute("funcionario", pesquisarFuncionario(idFuncionario));
        request.setAttribute("idFuncionario", idFuncionario);
        
        RequestDispatcher rd = request.getRequestDispatcher("AlterarDadosFuncionario.jsp");
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

        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));     
       
        
        String nome = request.getParameter("nomeFuncionario");
        String dtNasc = request.getParameter("dtNascimento");
        char genero = request.getParameter("inlineRadioOptions").charAt(0);
        String endereco = request.getParameter("enderecoFuncionario");
        long cpf =  Long.parseLong(request.getParameter("cpfFuncionario"));
        int rg =  Integer.parseInt(request.getParameter("rgFuncionario"));
        String cargo = request.getParameter("cargoFuncionario");
        int unidade = Integer.parseInt(request.getParameter("unidadeFuncionarioAtualizar"));
        String login = request.getParameter("loginFuncionario");
        String senha = request.getParameter("senhaFuncionario");
        char statusFuncionario = request.getParameter("inlineRadioOptionsFuncionario").charAt(0);
        
        
        
        Date dtNascimento = null;
        
        DateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dtNascimento = formatadorData.parse(dtNasc);
        } catch (ParseException ex) {
            Logger.getLogger(IncluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        Funcionario funcionario = new Funcionario(nome, cpf, rg, endereco, dtNascimento,
                genero, cargo, unidade, login, senha,statusFuncionario);
        alteraDadosFunc(idFuncionario, funcionario);
        
        request.setAttribute("confirmacao", "alteracao");
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
