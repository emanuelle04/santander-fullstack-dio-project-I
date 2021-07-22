package com.dio.live.service;


import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras save(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll(){
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> findById(Long id){
        return bancoHorasRepository.findById(id);
    }

    public BancoHoras update(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public void delete(Long id){
        bancoHorasRepository.deleteById(id);
    }


}
