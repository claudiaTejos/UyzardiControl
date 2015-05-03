package br.senac.tads.pi3.uyzardi;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudia.rgtejos
 */
public abstract class Pessoa {
    private int idPessoa;
    private String nome;
    private long cpf;
    private int rg;
    private String endereco;
    private Date dtNasc;
    private char genero;

    
    public Pessoa (String nome, long cpf, int rg, String endereco, Date dtNasc,
            char genero){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.genero = genero;
        this.dtNasc = dtNasc;
    }
    
    public Pessoa (int idPessoa, String nome, long cpf, int rg, String endereco,
            Date dtNasc, char genero){
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.genero = genero;
        this.dtNasc = dtNasc;
    }

    /**
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
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
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public int getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(int rg) {
        this.rg = rg;
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
     * @return the dt_nasc
     */
    public Date getDtNasc() {
        return dtNasc;
    }

    /**
     * @param dt_nasc the dt_nasc to set
     */
    public void setDtNasc(Date dt_nasc) {
        this.dtNasc = dt_nasc;
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
       
}