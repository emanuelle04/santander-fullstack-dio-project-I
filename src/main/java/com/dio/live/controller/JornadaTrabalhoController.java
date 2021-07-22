package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho create(@RequestBody JornadaTrabalho jornadaTrabalho){

        return jornadaService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getList(){
        return jornadaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(jornadaService.findById(id).orElseThrow(() -> new NoSuchElementException("Jornada not found.")));

    }
    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        jornadaService.delete(id);
    }

}
