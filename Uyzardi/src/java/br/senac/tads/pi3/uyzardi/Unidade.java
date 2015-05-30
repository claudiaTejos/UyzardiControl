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
public class Unidade {
    
    private int idUnidade;
    private String nome;
    private String endereco;
    private String cidade;
    private char status;

    public Unidade(String nome, String endereco, String cidade, char status) {
            this.nome = nome;
            this.endereco = endereco;
            this.cidade = cidade;
            this.status = status;
    }
    public Unidade(int idUnidade, String nome, String endereco, String cidade, char status){
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.status = status;
    }

    /**
     * @return the idUnidade
     */
    public int getIdUnidade() {
        return idUnidade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }

 
    
}
