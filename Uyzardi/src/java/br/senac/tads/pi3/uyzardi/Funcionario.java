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
    private Unidade unidade;

    public Funcionario(int idPessoa, String nome, int cpf, int rg, String endereco, Date dtNasc, char genero) {
        super(idPessoa, nome, cpf, rg, endereco, dtNasc, genero);
    }
    
    public Funcionario(String nome, int cpf, int rg, String endereco, Date dtNasc, char genero) {
        super(nome, cpf, rg, endereco, dtNasc, genero);
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
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    
    public static boolean login (String email, String senha){
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
                    return true;
                    
                }
                else{
                    return false;
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
        return false;
    }


     
}
