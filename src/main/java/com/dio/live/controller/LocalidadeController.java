package com.dio.live.controller;


import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade create(@RequestBody Localidade localidade){

        return localidadeService.save(localidade);
    }

    @GetMapping
    public List<Localidade> getList(){
        return localidadeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidade> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(localidadeService.findById(id).orElseThrow(() -> new NoSuchElementException("Localidade not found.")));

    }
    @PutMapping
    public Localidade update(@RequestBody Localidade localidade){
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        localidadeService.delete(id);
    }

}
