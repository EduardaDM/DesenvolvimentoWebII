package com.locadora.api.controller;
/*
Aqui implementei os verbos HTTP principais:
GET para consultas, POST para cadastro, PUT para
atualização e DELETE para remoção, tendo 2 extras
por modelo e mais baratos
 */

import com.locadora.api.model.Veiculo;
import com.locadora.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<Veiculo> listarTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id){
        return repository.findById(id)
                .map(veiculo -> ResponseEntity.ok().body(veiculo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(@RequestBody Veiculo veiculo){
        Veiculo salvo = repository.save(veiculo);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo dados){
        return repository.findById(id)
                .map(veiculoExistente -> {
                    veiculoExistente.setModelo(dados.getModelo());
                    veiculoExistente.setPlaca(dados.getPlaca()); // Adicionei update de placa
                    veiculoExistente.setValorDiaria(dados.getValorDiaria());
                    veiculoExistente.setLocadora(dados.getLocadora());
                    Veiculo atualizado = repository.save(veiculoExistente);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return repository.findById(id).map(veiculo -> {
                    repository.delete(veiculo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Select extra conforme enunciado (letra e)
    @GetMapping("/buscar-por-modelo")
    public List<Veiculo> buscarPorModelo(@RequestParam String termo) {
        return repository.findByModeloContaining(termo);
    }

    // Select extra conforme enunciado (letra e)
    @GetMapping("/baratos")
    public List<Veiculo> buscarBaratos(@RequestParam Double maximo) {
        return repository.findByValorDiariaLessThan(maximo);
    }
}