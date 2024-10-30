package com.example.algafood.domain.service;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Cozinha> listarTodasCozinhas(){

        return cozinhaRepository.findAll();

    }

}
