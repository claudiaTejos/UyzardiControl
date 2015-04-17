/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joana
 */
public class Aluno extends Pessoa{
    private int idAluno;
    private Unidade unidade;
    private Curso curso;
    private Responsavel responsavel;

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
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
    public Responsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    
    
    public void login(String email, String senha){
        
    }
    
}
