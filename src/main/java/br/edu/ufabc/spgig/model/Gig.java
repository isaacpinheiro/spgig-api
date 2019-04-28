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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gig")
public class Gig implements Serializable {
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "preco", nullable = false)
    private String preco;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_fim", nullable = true)
    private Date dataFim;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "horario_inicio", nullable = true)
    private Date horarioInicio;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "horario_fim", nullable = true)
    private Date horarioFim;
    
    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    @Column(name = "complemento", nullable = true)
    private String complemento;
    
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Column(name = "cep", nullable = true)
    private String cep;
    
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @Column(name = "site_evento", nullable = true)
    private String siteEvento;
    
    @Column(name = "site_ingresso", nullable = true)
    private String siteIngresso;
    
    @Column(name = "imagem_gig", nullable = true)
    private String imagemGig;
    
    @Column(name = "imagens", nullable = true)
    private String imagens;
    
    @ManyToOne
    @JoinColumn(name = "organizador_id", referencedColumnName = "id")
    private Organizador organizador;
    
    public Gig() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Date horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSiteEvento() {
        return siteEvento;
    }

    public void setSiteEvento(String siteEvento) {
        this.siteEvento = siteEvento;
    }

    public String getSiteIngresso() {
        return siteIngresso;
    }

    public void setSiteIngresso(String siteIngresso) {
        this.siteIngresso = siteIngresso;
    }

    public String getImagemGig() {
        return imagemGig;
    }

    public void setImagemGig(String imagemGig) {
        this.imagemGig = imagemGig;
    }

    public String getImagens() {
        return imagens;
    }

    public void setImagens(String imagens) {
        this.imagens = imagens;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }
    
}
