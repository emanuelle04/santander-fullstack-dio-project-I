package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/banco-horas")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras create(@RequestBody BancoHoras bancoHoras){

        return bancoHorasService.save(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoHoras> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(bancoHorasService.findById(id).orElseThrow(() -> new NoSuchElementException("Banco de Horas not found.")));

    }
    @PutMapping
    public BancoHoras update(@RequestBody BancoHoras categoriaUsuario){
        return bancoHorasService.update(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        bancoHorasService.delete(id);
    }

}
