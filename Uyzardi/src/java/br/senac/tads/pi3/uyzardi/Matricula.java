/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uyzardi;

import java.util.Date;

/**
 *
 * @author Claudio
 */
public class Matricula {
    private int idCliente;
    private int idMatricula;
    private Date dataMatricula;
    private int idFuncionario;
    private int idCurso;
    private String statusMatricula;
    private int idUnidade;
    
    public Matricula (int idCliente, Date dataMatricula, int idFuncionario, 
            int idCurso, String statusMatricula, int idUnidade){
        this.idCliente = idCliente;
        this.dataMatricula = dataMatricula;
        this.idFuncionario = idFuncionario;
        this.idCurso = idCurso;
        this.statusMatricula = statusMatricula;
        this.idUnidade = idUnidade;
    }
    
    public Matricula (int idCliente, int idMatricula, Date dataMatricula, 
            int idFuncionario, int idCurso, String statusMatricula){
        this.idCliente = idCliente;
        this.idMatricula = idMatricula;
        this.dataMatricula = dataMatricula;
        this.idFuncionario = idFuncionario;
        this.idCurso = idCurso;
        this.statusMatricula = statusMatricula;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idMatricula
     */
    public int getIdMatricula() {
        return idMatricula;
    }

    /**
     * @param idMatricula the idMatricula to set
     */
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    /**
     * @return the dataMatricula
     */
    public Date getDataMatricula() {
        return dataMatricula;
    }

    /**
     * @param dataMatricula the dataMatricula to set
     */
    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the statusMatricula
     */
    public String getStatusMatricula() {
        return statusMatricula;
    }

    /**
     * @param statusMatricula the statusMatricula to set
     */
    public void setStatusMatricula(String statusMatricula) {
        this.statusMatricula = statusMatricula;
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
}
