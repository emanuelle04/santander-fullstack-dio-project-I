package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //retorna JSON
@RequestMapping("/tipo-data")
public class TipoDataController {
    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData create(@RequestBody TipoData tipoData){

        return tipoDataService.save(tipoData);
    }

    @GetMapping
    public List<TipoData> getList(){
        return tipoDataService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoData> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(tipoDataService.findById(id).orElseThrow(() -> new NoSuchElementException("Tipo de Data not found")));

    }
    @PutMapping
    public TipoData update(@RequestBody TipoData tipoData){
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        tipoDataService.delete(id);
    }
}
