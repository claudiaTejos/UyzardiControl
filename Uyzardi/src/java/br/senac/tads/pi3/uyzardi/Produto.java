package br.senac.tads.pi3.uyzardi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudia.rgtejos
 */
public class Produto {
    
    private int idProduto;
    private String nomeProduto;
    private String idiomaProduto;
    private String moduloProduto;
    private double valorProduto;
    private int quantidadeProduto;

    public Produto(String nome, String idioma, String modulo, Double valor, int quantidade){
        this.nomeProduto = nome;
        this.idiomaProduto = idioma;
        this.moduloProduto = modulo;
        this.valorProduto = valor;
        this.quantidadeProduto = quantidade;
    }
    
    public Produto(int idProduto, String nome, String idioma, String modulo, Double valor, int quantidade){
        this.idProduto = idProduto;
        this.nomeProduto = nome;
        this.idiomaProduto = idioma;
        this.moduloProduto = modulo;
        this.valorProduto = valor;
        this.quantidadeProduto = quantidade;
    }
    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the idiomaProduto
     */
    public String getIdiomaProduto() {
        return idiomaProduto;
    }

    /**
     * @param idiomaProduto the idiomaProduto to set
     */
    public void setIdiomaProduto(String idiomaProduto) {
        this.idiomaProduto = idiomaProduto;
    }

    /**
     * @return the moduloProduto
     */
    public String getModuloProduto() {
        return moduloProduto;
    }

    /**
     * @param moduloProduto the moduloProduto to set
     */
    public void setModuloProduto(String moduloProduto) {
        this.moduloProduto = moduloProduto;
    }

    /**
     * @return the valorProduto
     */
    public double getValorProduto() {
        return valorProduto;
    }

    /**
     * @param valorProduto the valorProduto to set
     */
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    /**
     * @return the quantidadeProduto
     */
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    
    
    
}
