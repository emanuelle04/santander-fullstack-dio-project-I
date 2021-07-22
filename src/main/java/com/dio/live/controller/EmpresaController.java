package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa){

        return empresaService.save(empresa);
    }

    @GetMapping
    public List<Empresa> getList(){
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(empresaService.findById(id).orElseThrow(() -> new NoSuchElementException("Empresa not found.")));

    }
    @PutMapping
    public Empresa update(@RequestBody Empresa empresa){
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        empresaService.delete(id);
    }

}
