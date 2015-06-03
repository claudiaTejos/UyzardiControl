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
 * @author User
 */
@WebServlet(name = "RelatorioVendaServlet", urlPatterns = {"/RelatorioVendaServlet"})
public class RelatorioVendaServlet extends HttpServlet {
    
    public ArrayList<Relatorio> buscaDadosVendasPorUnidades(){
        String sql ="SELECT nomeUnidade, SUM(valor) Total " +
                "FROM Venda " +
                "JOIN Unidade ON Unidade.idUnidade = Venda.idUnidade " +
                "WHERE Venda.Status = 'A' " +
                "GROUP BY nomeUnidade";
        ArrayList<Relatorio> listaRelatorio = new ArrayList<>();
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            if (resultados != null) {
                while (resultados.next()){
                    Relatorio linhaRelatorio = new Relatorio(resultados.getString("nomeUnidade"),
                            resultados.getDouble("total")
                    );
                    listaRelatorio.add(linhaRelatorio);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return listaRelatorio;
    }
    
    public ArrayList<Relatorio> buscaDadosRelatorioVendas(){
        String sql ="SELECT nomeUnidade, idiomaProduto, nomeProduto, moduloProduto, SUM(valor) Total " +
                "FROM Venda " +
                "JOIN Produto ON Produto.idProduto = Venda.idProduto " +
                "JOIN Unidade ON Unidade.idUnidade = Venda.idUnidade " +
                "WHERE Venda.Status = 'A' " +
                "GROUP BY nomeUnidade, nomeProduto, Produto.idProduto";
        ArrayList<Relatorio> listaRelatorio = new ArrayList<>();
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            if (resultados != null) {
                while (resultados.next()){
                    Relatorio linhaRelatorio = new Relatorio(
                            resultados.getString("nomeUnidade"),
                            resultados.getString("idiomaProduto"),
                            resultados.getString("nomeProduto"),
                            resultados.getString("moduloProduto"),
                            resultados.getDouble("total")
                    );
                    listaRelatorio.add(linhaRelatorio);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return listaRelatorio;
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
            out.println("<title>Servlet RelatorioVendaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RelatorioVendaServlet at " + request.getContextPath() + "</h1>");
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
        ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
        request.setAttribute("dadosRelatorioVendaPorUnidade", buscaDadosVendasPorUnidades());
        RequestDispatcher rd = request.getRequestDispatcher("relatoriosVendas.jsp");
        rd.forward(request, response);        
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
        ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
        request.setAttribute("dadosRelatorioVendaPorUnidade", buscaDadosVendasPorUnidades());
        request.setAttribute("dadosRelatorioVendas", buscaDadosRelatorioVendas());
        RequestDispatcher rd = request.getRequestDispatcher("relatoriosVendas.jsp");
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
