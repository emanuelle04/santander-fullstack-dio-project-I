package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao){

        return movimentacaoService.save(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(movimentacaoService.getById(id).orElseThrow(() -> new NoSuchElementException("Movimentação not found.")));

    }
    @PutMapping
    public Movimentacao update(@RequestBody Movimentacao localidade){
        return movimentacaoService.update(localidade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        movimentacaoService.delete(id);
    }

}
