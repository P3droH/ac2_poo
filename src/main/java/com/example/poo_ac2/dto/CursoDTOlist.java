package com.example.poo_ac2.dto;

public class CursoDTOlist {
    private int codigo;
    private String nomeCurso;
    private String descricao;
    private int duracaoemMeses; 
    private double mensalidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracaoemMeses() {
        return duracaoemMeses;
    }

    public void setDuracaoemMeses(int duracaoemMeses) {
        this.duracaoemMeses = duracaoemMeses;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double custo) {
        this.mensalidade = custo;
    }
}
