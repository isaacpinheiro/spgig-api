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

public class Login implements Serializable {
    
    public static final long serialVersionUID = 1L;
    
    private String nomeUsuario;
    private String senha;
    
    public Login() {
        
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
