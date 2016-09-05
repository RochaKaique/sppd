/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Kaique
 */
public class LinhaDTO {
    
    private int codLinha;
    private String nomeLinha;
    private boolean ativa;

    public int getCodLinha() {
        return codLinha;
    }

    public void setCodLinha(int codLinha) {
        this.codLinha = codLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
}
