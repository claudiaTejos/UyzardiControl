package br.senac.tads.pi3.uyzardi;


import br.senac.tads.pi3.comum.ConnMysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joana
 */
public class Funcionario extends Pessoa {
    private String cargo;
    private int idUnidade;
    private String login;
    private String senha;

    public Funcionario(int idPessoa, String nome, long cpf, int rg, String endereco, Date dtNasc, char genero,
            String cargo, int unidade, String login,String senha) {
        super(idPessoa, nome, cpf, rg, endereco, dtNasc, genero);
        this.cargo = cargo;
        this.idUnidade = unidade;
        this.login = login; 
        this.senha = senha;
    }
    
    public Funcionario(String nome, long cpf, int rg, String endereco, Date dtNasc, char genero,
            String cargo, int unidade, String login,String senha) {
        super(nome, cpf, rg, endereco, dtNasc, genero);
        this.cargo = cargo;
        this.idUnidade = unidade;
        this.login = login; 
        this.senha = senha;
    }
    
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the idUnidade
     */
    public int getUnidade() {
        return idUnidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(int unidade) {
        this.idUnidade = unidade;
    }
     
    public static boolean login (String email, String senha){
        boolean login = false;
        Statement stmt = null;
        Connection conn = null;
    
        String sql = "SELECT `login`, `senha` FROM `Funcionario`";
        try {
            conn = ConnMysql.getConnection();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);
            
            while(resultados.next()){
                if(resultados.getString("login").equalsIgnoreCase(email) &&
                        resultados.getString("senha").equals(senha)){
                    login = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return login;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }


     
}
