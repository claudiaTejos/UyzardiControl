/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uyzardi;

/**
 *
 * @author User
 */
public class Relatorio {
    private String nomeUnidade;
    private String nomeCurso;
    private String moduloCurso;
    private double valorCurso;
    private int total;
    
    public Relatorio (String nomeUnidade, int total){
        this.nomeUnidade = nomeUnidade;
        this.total = total;
    }
    
    public Relatorio (String nomeUnidade, String nomeCurso, String moduloCurso, 
            double valorCurso, int total){
        this.nomeUnidade = nomeUnidade;
        this.nomeCurso = nomeCurso;
        this.moduloCurso = moduloCurso;
        this.valorCurso = valorCurso;
        this.total = total;
    }

    /**
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @return the nomeCurso
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * @return the moduloCurso
     */
    public String getModuloCurso() {
        return moduloCurso;
    }

    /**
     * @return the valorCurso
     */
    public double getValorCurso() {
        return valorCurso;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }
    
}
