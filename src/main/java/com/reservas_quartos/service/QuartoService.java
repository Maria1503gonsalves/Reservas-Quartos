package com.reservas_quartos.service;


import com.reservas_quartos.Entity.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservas_quartos.repository.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;

    public Quarto novoQuarto(Quarto quarto ){
        return quartoRepository.save(quarto);
    }
    public List <Quarto>obterTodosQuartos(){
        List<Quarto> quartos=new ArrayList<>();
        quartoRepository.findAll().forEach(quartos::add);
        return quartos;
    }
    public void excluirQuarto(Long id){
        quartoRepository.deleteById(id);
    }
    public List<Quarto>consultarDisponibilidade(){
        return quartoRepository.findByStatus("disponibilidade");
    }

}

