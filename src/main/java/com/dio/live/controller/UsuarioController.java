package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){

        return usuarioService.save(usuario);
    }

    @GetMapping
    public List<Usuario> getList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(usuarioService.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário not found")));

    }
    @PutMapping
    public Usuario update(@RequestBody Usuario tipoData){
        return usuarioService.update(tipoData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        usuarioService.delete(id);
    }
}
