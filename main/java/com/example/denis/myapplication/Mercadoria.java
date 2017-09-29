package com.example.denis.myapplication;

/**
 * Created by Aluno on 13/09/2017.
 */

public class Mercadoria {
    private String nome;
    private String qnt;
    private String categoria;;

    public Mercadoria(String nomes, String qant, String categorias) {
        this.nome = nomes;
        this.qnt = qant;
        this.categoria = categorias;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQnt() {
        return qnt;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria =  categoria;
    }
}