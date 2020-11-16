package com.example.poo_ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.poo_ac2.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {
    
    private ArrayList<Curso> cursos = new ArrayList<Curso>();
    private static int nextCodigo = 1;

    public List<Curso> getAllCursos() {
        return cursos;
    }

    public Optional<Curso> getCursoByCodigo(int codigo) {
        for(Curso aux : cursos) {
            if(aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Curso cadastrarCurso(Curso curso) {
        curso.setCodigo(nextCodigo++);
        cursos.add(curso);
        return curso;
    }

    public void removerEscola(Curso curso) {
        cursos.remove(curso);
    }

    public Curso alterarCurso(Curso curso) {

        Curso aux = getCursoByCodigo(curso.getCodigo()).get();

        if(aux != null) {
            aux.setMensalidade(curso.getMensalidade());
        }
        return aux;
    }
}
