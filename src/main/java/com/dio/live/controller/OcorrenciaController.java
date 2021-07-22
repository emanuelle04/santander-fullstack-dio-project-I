package com.dio.live.controller;


import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia create(@RequestBody Ocorrencia ocorrencia){

        return ocorrenciaService.save(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getList(){
        return ocorrenciaService.getList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(ocorrenciaService.getById(id).orElseThrow(() -> new NoSuchElementException("Ocorrência not found.")));

    }
    @PutMapping
    public Ocorrencia update(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        ocorrenciaService.delete(id);
    }

}
