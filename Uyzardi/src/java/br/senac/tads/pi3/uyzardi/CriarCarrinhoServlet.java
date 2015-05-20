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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author Joana
 */
@WebServlet(name = "CriarCarrinhoServlet", urlPatterns = {"/CriarCarrinhoServlet"})
public class CriarCarrinhoServlet extends HttpServlet {

    private List<Produto> listaProdutosPedidos;
    Map<Integer, Integer> idQuantidadeMap;
    
    private void montarCarrinho(){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM `Produto` WHERE `idProduto` IN (";
        int i=1;
        for(int id : idQuantidadeMap.keySet()) {
            if(i!=1) {
                sql +=", ";
            }
            sql += id;
            i++;
        }
        sql += ")";
        listaProdutosPedidos = new ArrayList<Produto>();
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet resultados = stmt.executeQuery(sql);
            while (resultados.next()){
                int idProduto = resultados.getInt("idProduto");
                Produto produto = new Produto(idProduto,
                        resultados.getString("nomeProduto"),
                        resultados.getString("idiomaProduto"),
                        resultados.getString("moduloProduto"),
                        resultados.getDouble("valorProduto"),
                        idQuantidadeMap.get(idProduto)
                        );
                listaProdutosPedidos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CriarCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CriarCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CriarCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private Cliente buscarCliente(long cpfCliente){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM `Cliente` WHERE `cpfCliente` = ?";
        Cliente cliente = null;
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, cpfCliente);
            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()){
                cliente = new Cliente(resultados.getInt("idCliente"),
                            resultados.getString("nomeCliente"),
                            resultados.getLong("cpfCliente"),
                            resultados.getInt("rgCliente"),
                            resultados.getString("enderecoCliente"),
                            resultados.getDate("dataNascimentoCliente"),
                            resultados.getString("sexoCliente").charAt(0)
                    );
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CriarCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CriarCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CriarCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return cliente;
            
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
            out.println("<title>Servlet CriarCarrinhoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CriarCarrinhoServlet at " + request.getContextPath() + "</h1>");
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
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterBase = "quantidade";
            if(parameterName.startsWith(parameterBase)) {
                int id = Integer.parseInt(parameterName.substring(parameterBase.length()));
                int quantidade = Integer.parseInt(request.getParameter(parameterName));
                if(quantidade > 0){
                    idQuantidadeMap.put(id, quantidade);
                }
            }
        }
        
        montarCarrinho();
        
        long cpfCliente = Long.parseLong(request.getParameter("cpfCliente"));
        Cliente cliente = buscarCliente(cpfCliente);
        
        if(cliente==null){
            request.setAttribute("etapa", "clienteNEncontrado");
            request.setAttribute("cpfNEncontrado", cpfCliente);
        }
        else{
            request.setAttribute("cliente", cliente);
            request.setAttribute("listaProdutosPedidos", listaProdutosPedidos);
            request.setAttribute("etapa", "carrinho");
        }
        
        
        request.setAttribute("paginaAtual", "venda");
        RequestDispatcher rd = request.getRequestDispatcher("telaPrincipal.jsp");
        rd.forward(request, response);

    }

}
