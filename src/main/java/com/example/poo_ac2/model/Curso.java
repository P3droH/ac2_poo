package com.example.poo_ac2.model;

public class Curso {
    
    private int codigo;
    private String nomeCurso;
    private String descricao;
    private int duracaoemMeses; 
    private double mensalidade;
    private Escola escola;

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

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}