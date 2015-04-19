package br.senac.tads.pi3.uyzardi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joana
 */
public class Aluno extends Pessoa{
    private int idAluno;
    private Unidade unidade;
    private Curso curso;
    private Responsavel responsavel;

    public Aluno(String nome, int cpf, int rg, String endereco, char genero) {
        super(nome, cpf, rg, endereco, genero);
    }
    
    public Aluno(int idPessoa, String nome, int cpf, int rg, String endereco, char genero) {
        super(idPessoa, nome, cpf, rg, endereco, genero);
    }
    
    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
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
    public Responsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    
}
