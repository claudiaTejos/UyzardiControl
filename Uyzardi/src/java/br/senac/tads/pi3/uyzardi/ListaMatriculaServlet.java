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
import java.util.Iterator;
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
@WebServlet(name = "listaMatricula", urlPatterns = {"/listaMatricula"})
public class ListaMatriculaServlet extends HttpServlet {
    
    public ArrayList<Matricula> listaMatricula (Object idCliente){
        ArrayList<Matricula> listaMatricula = new ArrayList<>();
        ResultSet resultados = null;
        Statement stmt = null;
        Connection conn = null;
        String sql;
        if (idCliente !=null) {
            sql = "SELECT * FROM `Matricula` WHERE `idCliente` = "+(int)idCliente;
        }
        else {
            sql = "SELECT * FROM `Matricula`";
        }
        
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            resultados = stmt.executeQuery(sql);
            if (resultados != null) {
                while (resultados.next()){
                    Matricula matricula = new Matricula(resultados.getInt("idCliente"),
                            resultados.getInt("idMatricula"),
                            resultados.getDate("dataHoraMatricula"),
                            resultados.getInt("idFuncionario"),
                            resultados.getInt("idCurso"),
                            resultados.getString("StatusMatricula")
                    );
                    listaMatricula.add(matricula);
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
        
        return listaMatricula;
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
            ArrayList<Matricula> listaMatricula = listaMatricula(null);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaMatriculaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaMatriculaServlet at " + request.getContextPath() + "</h1>");
            for (int i = 0; i < listaMatricula.size(); i++) {
                out.println(listaMatricula.get(i).getIdMatricula());
                out.println(listaMatricula.get(i).getDataMatricula());
                out.println(listaMatricula.get(i).getStatusMatricula());
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
        Cliente cliente = null;
        if ((request.getParameter("btnAcoesHiddenIDCliente")) != null) {
            cliente = PesquisarClienteServlet.pesquisaClienteID(Integer.parseInt(request.getParameter("btnAcoesHiddenIDCliente"))); 
            request.setAttribute("cliente", cliente);
        } 
        ListarCursosServlet listaCursos = new ListarCursosServlet();
        ArrayList<Curso> listaCursosUnidades = listaCursos.pesquisaCurso("");
        for(Iterator<Curso> iterador = listaCursosUnidades.iterator(); iterador.hasNext();){
            Curso atual = iterador.next();
            if (cliente.getIdUnidade() != atual.getIdUnidade()) {
                iterador.remove();
            }
        }
        request.setAttribute("listaUnidades", listaUnidades.pesquisarUnidade(""));
        request.setAttribute("cursos", listaCursosUnidades);
        request.setAttribute("listaMatricula", listaMatricula(cliente.getIdPessoa()));
        request.setAttribute("clickBtnListaMatricula", "true");
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
