package com.example.poo_ac2.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.example.poo_ac2.dto.CursoDTOlist;
import com.example.poo_ac2.dto.EscolaDTO;
import com.example.poo_ac2.model.Curso;
import com.example.poo_ac2.model.Escola;
import com.example.poo_ac2.service.CursoService;
import com.example.poo_ac2.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Escola> getEscolas() {
        return escolaService.getAllEscolas();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerEscola(@PathVariable int codigo) {
        escolaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Escola> atualizarEscola(@RequestBody EscolaDTO escolaDTO, @PathVariable int codigo) {
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setCodigo(codigo);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Escola> getEscolaByCodigo(@PathVariable int codigo) {
        Escola escola = escolaService.getEscolaByCodigo(codigo);
        return ResponseEntity.ok(escola);
    }

    @PostMapping()
    public ResponseEntity<Escola> salvarEscola(@RequestBody Escola escola, HttpServletRequest request, UriComponentsBuilder builder) {
        Escola novaEscola = escolaService.save(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novaEscola.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PostMapping("/{idEscola}/cursos")
    public ResponseEntity<Curso> salvarCurso(@PathVariable int idEscola, @RequestBody Curso curso, HttpServletRequest request, UriComponentsBuilder builder) {
        Curso novoCurso = cursoService.save(curso, idEscola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novoCurso.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{idEscola}/cursos")
    public List<CursoDTOlist> getCursosEscola(@PathVariable int idEscola) {
        Escola escola = escolaService.getEscolaByCodigo(idEscola);
        return cursoService.toListDTO(escola.getCursos());
    }

}