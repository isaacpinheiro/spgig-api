/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.spgig.model;

/**
 *
 * @author isaac
 */

import java.io.Serializable;

public class Busca implements Serializable {
    
    public static final long serialVersionUID = 1L;
    
    private String tipo;
    private String cidade;
    
    public Busca() {
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}
