package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;

import com.dio.live.service.CategoriaUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/categoria")
public class CategoriaUsuarioController {
    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario){

        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(categoriaUsuarioService.findById(id).orElseThrow(() -> new NoSuchElementException("Categoria not found.")));

    }
    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.update(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        categoriaUsuarioService.delete(id);
    }

}
