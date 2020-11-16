package com.example.poo_ac2.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Escola {
    
    private int codigo;
    private String nomeEscola;
    private String descricao; 
    private String endereco;
    private int notaWEB;
    
    @JsonIgnore
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNotaWEB() {
        return notaWEB;
    }

    public void setNotaWEB(int notaMEC) {
        this.notaWEB = notaMEC;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public boolean addCurso(Curso curso) {
        return cursos.add(curso);
    }

    public boolean removeCurso(Curso curso) {
        return cursos.remove(curso);
    }
}
