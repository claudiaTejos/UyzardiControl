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
 * @author Claudio
 */
@WebServlet(name = "pesquisarCliente", urlPatterns = {"/pesquisarCliente"})
public class PesquisarClienteServlet extends HttpServlet {
    
    public ArrayList<Cliente> pesquisarClientes (String pesquisa){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        
        String sql;
        if (pesquisa.equals("")) {
             sql = "SELECT * FROM Cliente";
        }
        else{
            sql = "SELECT * FROM `Cliente` WHERE `nomeCliente` LIKE '%"+pesquisa+"%'";
        }
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            
            if (resultados != null) {
                while (resultados.next()){
                    Cliente cliente = new Cliente(resultados.getInt("idCliente"),
                            resultados.getString("nomeCliente"),
                            resultados.getLong("cpfCliente"),
                            resultados.getInt("rgCliente"),
                            resultados.getString("enderecoCliente"),
                            resultados.getDate("dataNascimentoCliente"),
                            resultados.getString("sexoCliente").charAt(0)
                    );
                    listaClientes.add(cliente);
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
        
        return listaClientes;
    }
    
    public static Cliente pesquisaClienteID (int id){
        PesquisarClienteServlet ps = new PesquisarClienteServlet();
        ArrayList<Cliente> clientes = ps.pesquisarClientes("");
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdPessoa() == id) {
                return clientes.get(i);
            }
        }
        return null;
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
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PesquisarAluno</title>");            
            out.println("</head>");
            out.println("<body>");
            ArrayList<Cliente> lista = pesquisarClientes("");
            for (int i = 0; i < lista.size(); i++) {
                out.print(lista.get(i).getIdPessoa());
                out.print(lista.get(i).getNome());
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
        ListarUnidadeServlet listaUnidades = new ListarUnidadeServlet();
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
        request.setAttribute("listaClientes", pesquisarClientes((String)request.getParameter("nomeAluno")));
        request.setAttribute("clickBtnPesquisa","true");
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
