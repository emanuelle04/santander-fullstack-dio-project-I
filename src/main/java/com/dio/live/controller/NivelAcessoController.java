package com.dio.live.controller;


import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivel-acesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso create(@RequestBody NivelAcesso nivelAcesso){

        return nivelAcessoService.save(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> getList(){
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelAcesso> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(nivelAcessoService.getById(id).orElseThrow(() -> new NoSuchElementException("Nivel de Acesso not found.")));

    }
    @PutMapping
    public NivelAcesso update(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        nivelAcessoService.delete(id);
    }

}
