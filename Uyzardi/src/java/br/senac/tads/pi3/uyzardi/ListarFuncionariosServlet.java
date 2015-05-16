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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Elisabete
 */
@WebServlet(name = "ListarFuncionariosServlet", urlPatterns = {"/ListarFuncionariosServlet"})
public class ListarFuncionariosServlet extends HttpServlet {
    
        public ArrayList<Funcionario> pesquisarFuncionario (String pesquisa){
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        
        String sql;
        if (pesquisa.equals("")) {
             sql = "SELECT * FROM Funcionario";
        }
        else{
            sql = "SELECT * FROM `Funcionario` WHERE `nomeFuncionario` LIKE '%"+pesquisa+"%'";
        }
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            
            if (resultados != null) {
                while (resultados.next()){
                    Funcionario funcionario = new Funcionario(resultados.getInt("idFuncionario"),
                            resultados.getString("nomeFuncionario"),
                            resultados.getLong("cpfFuncionario"),
                            resultados.getInt("rgFuncionario"),
                            resultados.getString("endFuncionario"),
                            resultados.getDate("dataNascFuncionario"),
                            resultados.getString("generoFuncionario").charAt(0),
                            resultados.getString("cargo"),
                            resultados.getInt("idUnidade"),
                            resultados.getString("login"),
                            resultados.getString("senha"));
                    listaFuncionario.add(funcionario);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarFuncionariosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return listaFuncionario;
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
            out.println("<title>Servlet ListarFuncionariosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            ArrayList<Funcionario> lista = pesquisarFuncionario("");
            for (int i = 0; i < lista.size(); i++) {
                //out.print(lista.get(i).getIdPessoa());
                out.print(lista.get(i).getNome());
                out.print(lista.get(i).getCargo());
            }
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
        request.setAttribute("listaFuncionario", pesquisarFuncionario((String)request.getParameter("nomeFuncionario")));
        request.setAttribute("clickBtnPesquisaFuncionario","true");
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
