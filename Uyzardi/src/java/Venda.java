/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudia.rgtejos
 */
public class Venda {
    private int idVenda;
    private int idAluno;
    private int idFuncionario;
    private Estoque estoque;

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @return the estoque
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    
}
