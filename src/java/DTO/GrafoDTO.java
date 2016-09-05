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
public class GrafoDTO {
    
    int codEstacao;
    int codEstacaoProx;
    double distancia;

    public int getCodEstacao() {
        return codEstacao;
    }

    public void setCodEstacao(int codEstacao) {
        this.codEstacao = codEstacao;
    }

    public int getCodEstacaoProx() {
        return codEstacaoProx;
    }

    public void setCodEstacaoProx(int codEstacaoProx) {
        this.codEstacaoProx = codEstacaoProx;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
}
