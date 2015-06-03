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
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
 * @author Joana
 */
@WebServlet(name = "RealizarCompraServlet", urlPatterns = {"/RealizarCompraServlet"})
public class RealizarCompraServlet extends HttpServlet {

    Map<Integer, Integer> idQuantidadeMap;
    Map<Integer, Double> idValorMap;
    
    private void realizarCompra(int idCliente, int idUnidade){
        
        Date data = new Date();
        java.sql.Date dateSql = new java.sql.Date(data .getTime()) ;
        
        
        for(int id : idQuantidadeMap.keySet()) {
            
            PreparedStatement stmt = null;
            Connection conn = null;
            
            String sql = "INSERT INTO `Venda`"
                + "(`idCliente`, `idProduto`, "
                + "`dataHoraVenda`, `valor`, `idUnidade`) VALUES "
                + "(?,?,?,?,?)";
            
            try {
                conn = ConnMysql.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idCliente);
                stmt.setInt(2, idQuantidadeMap.get(id));
                stmt.setDate(3, dateSql);
                stmt.setDouble(4, idValorMap.get(id));
                stmt.setInt(5, idUnidade);
                stmt.executeUpdate();
                System.out.println("Incluído com sucesso");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                if(stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }   
    }
    
    private void debitarQuantidades(){
        
        for(int id : idQuantidadeMap.keySet()) {
            
            PreparedStatement stmt = null;
            Connection conn = null;
            int quantidadeAnterior = 0;
            
            String sql = "SELECT `quantidade` FROM `Produto` WHERE `idProduto` = ?";
            
            try {
                conn = ConnMysql.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet resultados = stmt.executeQuery();
                while (resultados.next()){
                    quantidadeAnterior = resultados.getInt("quantidade");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if(stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
            
            sql = "UPDATE `Produto` set `quantidade` = ? WHERE `idProduto` = ?";
            
            try {
                conn = ConnMysql.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, (quantidadeAnterior - idQuantidadeMap.get(id)));
                stmt.setInt(2, id);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                if(stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(RealizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
            out.println("<title>Servlet RealizarCompraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RealizarCompraServlet at " + request.getContextPath() + "</h1>");
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
        
        idQuantidadeMap = new HashMap<>();
        idValorMap = new HashMap<>();
        
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterBase1 = "quantidade";
            String parameterBase2 = "valor";
            if(parameterName.startsWith(parameterBase1)) {
                int id = Integer.parseInt(parameterName.substring(parameterBase1.length()));
                int quantidade = Integer.parseInt(request.getParameter(parameterName));
                if(quantidade > 0){
                    idQuantidadeMap.put(id, quantidade);
                }
            }
            if(parameterName.startsWith(parameterBase2)) {
                int id = Integer.parseInt(parameterName.substring(parameterBase2.length()));
                double valor = Double.parseDouble(request.getParameter(parameterName));
                if(valor > 0){
                    idValorMap.put(id, valor);
                }
            }
        }
        
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        HttpSession sessao = request.getSession();
        Unidade unidade = (Unidade)sessao.getAttribute("unidade");
        
        realizarCompra(idCliente, unidade.getIdUnidade());
        debitarQuantidades();
        
        request.setAttribute("paginaAtual", "venda");
        request.setAttribute("confirmacao", "compra");
        
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
