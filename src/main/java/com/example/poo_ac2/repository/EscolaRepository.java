package com.example.poo_ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.poo_ac2.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    
    private ArrayList<Escola> escolas = new ArrayList<Escola>();
    private int nextCode;

    @PostConstruct
    public void criarEscolas() {
        
        Escola e1 = new Escola();
        Escola e2 = new Escola();
        Escola e3 = new Escola();

        e1.setCodigo(1);
        e1.setNomeEscola("nomeEscola");
        e1.setDescricao("descricao");
        e1.setEndereco("endereco");
        e1.setNotaWEB(4);

        e2.setCodigo(2);
        e2.setNomeEscola("nomeEscola");
        e2.setDescricao("descricao");
        e2.setEndereco("endereco");
        e2.setNotaWEB(4);

        e3.setCodigo(3);
        e3.setNomeEscola("nomeEscola");
        e3.setDescricao("descricao");
        e3.setEndereco("endereco");
        e3.setNotaWEB(4);

        escolas.add(e1);
        escolas.add(e2);
        escolas.add(e3);

        nextCode = 4;
    }

    public List<Escola> getAllEscolas() {
        return escolas;
    }

    public Optional<Escola> getEscolaByCodigo(int codigo) {
        for(Escola aux : escolas) {
            if(aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Escola cadastrarEscola(Escola escola) {
        escola.setCodigo(nextCode++);
        escolas.add(escola);
        return escola;
    }

    public void removerEscola(Escola escola) {
        escolas.remove(escola);
    }

    public Escola alterarEscola(Escola escola) {

        Escola aux = getEscolaByCodigo(escola.getCodigo()).get();

        if(aux != null) {
            aux.setNotaWEB(escola.getNotaWEB());;
            aux.setDescricao(escola.getDescricao());
        }
        return aux;
    }
}
