package br.senac.tads.pi3.uyzardi;

import br.senac.tads.pi3.comum.ConnMysql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Cauê Camargo
 */
@WebServlet(name = "IncluirCursoServlet", urlPatterns = {"/IncluirCursoServlet"})
public class IncluirCursoServlet extends HttpServlet {

    private boolean incluirCurso(Curso curso) {
        boolean controle = false;
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO `Curso`"
                + "(nomeCurso, moduloCurso, salaCurso, valorCurso, vagasCurso, idUnidade, periodo) VALUES"
                + "(?,?,?,?,?,?,?)";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getModuloCurso());
            stmt.setInt(3, curso.getSalaCurso());
            stmt.setDouble(4, curso.getValor());
            stmt.setInt(5 ,curso.getQtd_vagas());
            stmt.setObject(6, curso.getIdUnidade());
            stmt.setString(7 ,curso.getPeriodo());
            stmt.executeUpdate();
            controle = true;
            System.out.println("Incluido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(IncluirCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IncluirCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return controle;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IncluirCursoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IncluirCursoServlet at " + request.getContextPath() + "</h1>");
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
 
        String nomecurso = request.getParameter("nomeCurso");
        String  modulocurso = request.getParameter("moduloCurso");
        int salacurso = Integer.parseInt(request.getParameter("salaCurso"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int qtd_vagas = Integer.parseInt(request.getParameter("vagas"));
        int unidade = Integer.parseInt(request.getParameter("unidade"));
        String periodo = request.getParameter("periodo");
            
        Curso curso = new Curso(nomecurso, modulocurso, salacurso, valor, qtd_vagas, unidade, periodo);

        incluirCurso(curso);

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
