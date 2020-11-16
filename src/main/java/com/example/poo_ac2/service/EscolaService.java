package com.example.poo_ac2.service;

import java.util.List;
import java.util.Optional;

import com.example.poo_ac2.dto.EscolaDTO;
import com.example.poo_ac2.model.Escola;
import com.example.poo_ac2.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {
    
    @Autowired
    private EscolaRepository repository;

    private Escola escola;
    
    public Escola fromDTO(EscolaDTO dto) {

        Escola escola = new Escola();

        escola.setNotaWEB(dto.getNotaWEB());
        escola.setDescricao(dto.getDescricao());;

        return escola;
    }

    public List<Escola> getAllEscolas() {
        return repository.getAllEscolas();
    }

    public void removeByCodigo(int codigo) {
        if(escola.getCursos().isEmpty()) {
            repository.removerEscola(getEscolaByCodigo(codigo));
        }
    }

    public Escola update(Escola escola) {
        getEscolaByCodigo(escola.getCodigo());
        return repository.alterarEscola(escola);
    }

    public Escola getEscolaByCodigo(int codigo) {
        Optional<Escola> op = repository.getEscolaByCodigo(codigo);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Escola nao encontrada!")); 
    }

    public Escola save(Escola escola) {
        return repository.cadastrarEscola(escola);
    }
}

    