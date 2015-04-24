package br.senac.tads.pi3.uyzardi;

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

    public Cliente(String nome, int cpf, int rg, String endereco, Date dtNasc, char genero) {
        super(nome, cpf, rg, endereco, dtNasc, genero);
    }

    public Cliente(int idPessoa, String nome, int cpf, int rg, String endereco, Date dtNasc, char genero) {
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
    
    
}
