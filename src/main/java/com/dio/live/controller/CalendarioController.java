package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario create(@RequestBody Calendario calendario){

        return calendarioService.save(calendario);
    }

    @GetMapping
    public List<Calendario> getList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendario> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(calendarioService.findById(id).orElseThrow(() -> new NoSuchElementException("Calendario not found.")));

    }
    @PutMapping
    public Calendario update(@RequestBody Calendario calendario){
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        calendarioService.delete(id);
    }

}
