/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uyzardi;

import br.senac.tads.pi3.comum.ConnMysql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Cauê Camrgo
 */
@WebServlet(name = "AlterarDadosCursoServlet", urlPatterns = {"/AlterarDadosCursoServlet"})
public class AlterarDadosCursoServlet extends HttpServlet {

    public void alteraDadosCurso(int idCurso, Curso curso ){

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE `Curso` SET `nomeCurso` = ?, `moduloCurso` = ?,"
                + "`salaCurso` = ?, `valorCurso`= ?, `vagasCurso`= ?, `idUnidade`= ?,"
                + "`periodo`= ?, `Status`= ? WHERE `idCurso` = ?";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getModuloCurso());
            stmt.setInt(3, curso.getSalaCurso());
            stmt.setDouble(4, curso.getValor());
            stmt.setInt(5 ,curso.getQtdVagas());
            stmt.setObject(6, curso.getIdUnidade());
            stmt.setString(7 ,curso.getPeriodo());
            stmt.setObject(8, curso.getStatus(), java.sql.Types.VARCHAR);
            stmt.setInt(9, idCurso);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarDadosCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    public Curso pesquisarCurso (int idCurso){
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        Curso curso = null;
        
        String sql = "SELECT * FROM `Curso` WHERE `idCurso`= '"+idCurso+"'";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            
            if (resultados != null) {
                while (resultados.next()){
                    curso = new Curso(
                        resultados.getInt("idCurso"),
                        resultados.getString("nomeCurso"),
                        resultados.getString("moduloCurso"),
                        resultados.getInt("salaCurso"),
                        resultados.getDouble("valorCurso"),
                        resultados.getInt("vagasCurso"),
                        resultados.getInt("idUnidade"),
                        resultados.getString("periodo"),
                        resultados.getString("Status").charAt(0)
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlterarDadosCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        return curso;
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
        
        int idCurso = Integer.parseInt(request.getParameter("idCurso")); 
        request.setAttribute("curso", pesquisarCurso(idCurso));
        request.setAttribute("idCurso", idCurso);
        
        RequestDispatcher rd = request.getRequestDispatcher("AlterarDadosCurso.jsp");
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
        
        int idCurso= Integer.parseInt(request.getParameter("idCurso"));
        String nomecurso = request.getParameter("nomeCurso");
        String  modulocurso = request.getParameter("moduloCurso");
        int salacurso = Integer.parseInt(request.getParameter("salaCurso"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int qtdVagas = Integer.parseInt(request.getParameter("vagas"));
        int unidade = Integer.parseInt(request.getParameter("idUnidade"));
        String periodo = request.getParameter("periodo");
        char status = request.getParameter("inlineRadioOptionsCurso").charAt(0);
            
        Curso curso = new Curso(idCurso, nomecurso, modulocurso, salacurso, valor, qtdVagas, unidade, periodo, status);
        alteraDadosCurso(idCurso,curso);
        
        request.setAttribute("confirmacao", "alteracao");
        ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
        RequestDispatcher rd = request.getRequestDispatcher("ListarCursosServlet");
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
