package com.dio.live.service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> findById(Long id){
        return empresaRepository.findById(id);
    }

    public Empresa update(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public void delete(Long id){
        empresaRepository.deleteById(id);
    }


}
