
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudia.rgtejos
 */
public class Estoque {
    
    private int idEstoque;
    private ArrayList<Produto> produto;
    private Unidade unidade;
    private int qtdeProduto;

    /**
     * @return the idEstoque
     */
    public int getIdEstoque() {
        return idEstoque;
    }

    /**
     * @return the produto
     */
    public ArrayList<Produto> getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ArrayList<Produto> produto) {
        this.produto = produto;
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
     * @return the qtdeProduto
     */
    public int getQtdeProduto() {
        return qtdeProduto;
    }

    /**
     * @param qtdeProduto the qtdeProduto to set
     */
    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }
    
    
}
