package com.example.denis.tecladov3;



/**
 * Created by rafael on 01/12/16.
 */

public class UserModel {//chama-se Livro

    /*private final String nomeLivro;
    private final String nomeAutor;
    private final String descricao;
    private final Double preco;*/


    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    private  String nomeLivro;
    private  String nomeAutor;
    private  String descricao;
    private  Double preco;


 /*


    public UserModel(String nomeLivro, String nomeAutor,
                 String descricao, Double preco) {

        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.descricao = descricao;
        this.preco = preco;
    }*/


    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }
}
