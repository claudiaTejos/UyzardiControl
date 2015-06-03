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
public class Curso {
    
    private int idCurso;
    private String nomeCurso;
    private String moduloCurso;
    private int salaCurso;
    private int qtdVagas;
    private double valor;
    private String periodo;
    private int idUnidade;
    private char status;

    Curso(int idCurso , String nomecurso, String modulocurso, int salacurso, double valor, int qtdVagas, int idUnidade, String periodo, char status) {
        this.idCurso = idCurso;
        this.nomeCurso = nomecurso;
        this.moduloCurso = modulocurso;
        this.salaCurso = salacurso;
        this.qtdVagas = qtdVagas;
        this.valor = valor;
        this.idUnidade = idUnidade;
        this.periodo = periodo;
        this.status = status;
    }
    Curso(String nomeCurso, String modulocurso, int salacurso, double valor, int qtdVagas, int idUnidade, String periodo, char status) {
        this.nomeCurso = nomeCurso;
        this.moduloCurso = modulocurso;
        this.salaCurso = salacurso;
        this.qtdVagas = qtdVagas;
        this.valor = valor;
        this.idUnidade = idUnidade;
        this.periodo = periodo;
        this.status = status;
    }

    /**
     * @return the id_curso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @return the qtd_vagas
     */
    public int getQtdVagas() {
        return qtdVagas;
    }

    /**
     * @param qtd_vagas the qtd_vagas to set
     */
    public void setQtd_vagas(int qtd_vagas) {
        this.qtdVagas = qtd_vagas;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    /**
     * @return the modulo
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * @param nomeCurso the nomeCurso to set
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    /**
     * @return the sala
     */
    public int getSalaCurso() {
        return salaCurso;
    }

    /**
     * @param salaCurso the salaCurso to set
     */
    public void setSalaCurso(int salaCurso) {
        this.salaCurso = salaCurso;
    }

    /**
     * @return the moduloCurso
     */
    public String getModuloCurso() {
        return moduloCurso;
    }

    /**
     * @param moduloCurso the moduloCurso to set
     */
    public void setModuloCurso(String moduloCurso) {
        this.moduloCurso = moduloCurso;
    }

    /**
     * @return the idUnidade
     */
    public int getIdUnidade() {
        return idUnidade;
    }

    /**
     * @param idUnidade the idUnidade to set
     */
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    } 

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
