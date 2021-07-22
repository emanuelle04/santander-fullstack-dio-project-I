package com.dio.live.service;


import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRepository movimentacaoRepository;
    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao save(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }
    public Optional<Movimentacao> getById(Long id){
        return movimentacaoRepository.findById(id);
    }
    public Movimentacao update(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public void  delete(Long id){
        movimentacaoRepository.deleteById(id);
    }

}
