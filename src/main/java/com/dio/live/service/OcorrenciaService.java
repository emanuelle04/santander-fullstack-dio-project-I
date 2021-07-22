package com.dio.live.service;


import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OcorrenciaService {

    OcorrenciaRepository ocorrenciaRepository;
    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia save(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> getList(){
        return ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> getById(Long id){
        return ocorrenciaRepository.findById(id);
    }

    public Ocorrencia update(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void  delete(Long id){
        ocorrenciaRepository.deleteById(id);
    }
}
