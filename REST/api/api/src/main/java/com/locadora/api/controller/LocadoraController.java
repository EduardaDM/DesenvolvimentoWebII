package com.locadora.api.controller;


import com.locadora.api.model.Locadora;
import com.locadora.api.repository.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

    @Autowired
    private LocadoraRepository repository;

    // 1. Listar todas as locadoras
    @GetMapping
    public List<Locadora> listar() {
        return repository.findAll();
    }

    // 2. Buscar locadora por ID
    @GetMapping("/{id}")
    public ResponseEntity<Locadora> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(locadora -> ResponseEntity.ok().body(locadora))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Criar nova locadora
    @PostMapping
    public ResponseEntity<Locadora> cadastrar(@RequestBody Locadora locadora) {
        Locadora salva = repository.save(locadora);
        return ResponseEntity.status(201).body(salva);
    }

    // 4. Atualizar locadora existente
    @PutMapping("/{id}")
    public ResponseEntity<Locadora> atualizar(@PathVariable Long id, @RequestBody Locadora dados) {
        return repository.findById(id)
                .map(locadoraExistente -> {
                    locadoraExistente.setNome(dados.getNome());
                    // Se tiver outros campos, atualize aqui
                    Locadora atualizada = repository.save(locadoraExistente);
                    return ResponseEntity.ok().body(atualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Deletar locadora
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
