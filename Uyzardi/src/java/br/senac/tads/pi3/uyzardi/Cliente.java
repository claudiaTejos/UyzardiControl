package br.senac.tads.pi3.uyzardi;

import br.senac.tads.pi3.comum.ConnMysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joana
 */
public class Cliente extends Pessoa{
    private Unidade unidade;
    private Curso curso;
    private Cliente responsavel;

    public Cliente(String nome, long cpf, int rg, String endereco, Date dtNasc, char genero) {
        super(nome, cpf, rg, endereco, dtNasc, genero);
    }

    public Cliente(int idPessoa, String nome, long cpf, int rg, String endereco, Date dtNasc, char genero) {
        super(idPessoa, nome, cpf, rg, endereco, dtNasc, genero);
    }
    
    public void atualizarCliente(Cliente atualizado){
        this.setNome(atualizado.getNome());
        this.setCpf(atualizado.getCpf());
        this.setDtNasc(atualizado.getDtNasc());
        this.setRg(atualizado.getRg());
        this.setEndereco(atualizado.getEndereco());
        this.setGenero(atualizado.getGenero());
        this.setResponsavel(atualizado.getResponsavel());
        this.setUnidade(atualizado.getUnidade());
        this.setCurso(atualizado.getCurso());
        
    }
    
    /**
     * @return the unidade
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

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the responsavel
     */
    public Cliente getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
    }
    
    public static ArrayList<Cliente> pesquisarCliente () throws SQLException{
        ArrayList<Cliente> listaAluno = new ArrayList<>();
        ResultSet resultados = ConnMysql.selectAll("Cliente");
        if (resultados != null) {
            while (resultados.next()){
                Cliente aluno = new Cliente(resultados.getInt("idAluno"),
                            resultados.getString("nomePessoa"),
                            resultados.getInt("cpf"),
                            resultados.getInt("rg"),
                            resultados.getString("enderecoPessoa"),
                            resultados.getDate("dataNescimento"),
                            (char)resultados.getObject("sexo")
                );
                listaAluno.add(aluno);
            }
        }
        return listaAluno;
    }
}
