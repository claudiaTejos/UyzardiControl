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
    private int moduloCurso;
    private int salaCurso;
    private Unidade unidade;
    private int qtd_vagas;
    private double valor;

    /**
     * @return the id_curso
     */
    public int getId_curso() {
        return idCurso;
    }

    /**
     * @return the qtd_vagas
     */
    public int getQtd_vagas() {
        return qtd_vagas;
    }

    /**
     * @param qtd_vagas the qtd_vagas to set
     */
    public void setQtd_vagas(int qtd_vagas) {
        this.qtd_vagas = qtd_vagas;
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
    public int getModulo() {
        return getModuloCurso();
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(int modulo) {
        this.setModuloCurso(modulo);
    }

    /**
     * @return the sala
     */
    public int getSala() {
        return getSalaCurso();
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(int sala) {
        this.setSalaCurso(sala);
    }

    /**
     * @return the moduloCurso
     */
    public int getModuloCurso() {
        return moduloCurso;
    }

    /**
     * @param moduloCurso the moduloCurso to set
     */
    public void setModuloCurso(int moduloCurso) {
        this.moduloCurso = moduloCurso;
    }

    /**
     * @return the salaCurso
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
     
}
