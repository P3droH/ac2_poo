package com.example.poo_ac2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.poo_ac2.dto.CursoDTO;
import com.example.poo_ac2.dto.CursoDTOlist;
import com.example.poo_ac2.model.Curso;
import com.example.poo_ac2.model.Escola;
import com.example.poo_ac2.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    @Autowired
    private EscolaService escolaService;

    public Curso fromDTO(CursoDTO dto) {

        Curso curso = new Curso();

        curso.setMensalidade(dto.getMensalidade());

        return curso;
    }
    
    public List<Curso> getAllCursos() {
        return repository.getAllCursos();
    }

    public Curso getCursoByCodigo(int codigo) {
        Optional<Curso> op = repository.getCursoByCodigo(codigo);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso nao cadastrado!"));
    }

    public void removeByCodigo(int codigo) {
        repository.removerEscola(getCursoByCodigo(codigo));
    }

    public Curso save(Curso curso, int idEscola) {
        Escola escola = escolaService.getEscolaByCodigo(idEscola);
        curso.setEscola(escola);
        escola.addCurso(curso);
        return repository.cadastrarCurso(curso);
    } 

    public Curso update(Curso curso) {
        getCursoByCodigo(curso.getCodigo());
        return repository.alterarCurso(curso);
    }

    public CursoDTOlist toDTO(Curso curso) {
        
        CursoDTOlist dto = new CursoDTOlist();

        dto.setCodigo(curso.getCodigo());
        dto.setNomeCurso(curso.getNomeCurso());
        dto.setDescricao(curso.getDescricao());
        dto.setDuracaoemMeses(curso.getDuracaoemMeses());
        dto.setMensalidade(curso.getMensalidade());
        
        return dto;
    }

    public List<CursoDTOlist> toListDTO(List<Curso> cursos) {
        ArrayList<CursoDTOlist> listDTO = new ArrayList<CursoDTOlist>();

        for(Curso c: cursos) {
            listDTO.add(toDTO(c));
        }
        return listDTO;
    }
}