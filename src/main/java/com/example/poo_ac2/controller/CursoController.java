package com.example.poo_ac2.controller;

import java.util.List;

import com.example.poo_ac2.dto.CursoDTO;
import com.example.poo_ac2.model.Curso;
import com.example.poo_ac2.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService service;

    @GetMapping()
    public List<Curso> getCursos() {
        return service.getAllCursos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Curso> getCursoByCodigo(@PathVariable int codigo) {
        Curso curso = service.getCursoByCodigo(codigo);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerCurso(@PathVariable int codigo) {
        service.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Curso> atualizarCurso(@RequestBody CursoDTO cursoDTO, @PathVariable int codigo) {
        Curso curso = service.fromDTO(cursoDTO);
        curso.setCodigo(codigo);
        curso = service.update(curso);
        return ResponseEntity.ok(curso);
    }
}
