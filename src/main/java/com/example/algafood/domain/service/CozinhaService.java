package com.example.algafood.domain.service;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.repository.CozinhaRepository;
import jakarta.transaction.Transactional;
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

    public Cozinha buscarCozinhaId(Long idCozinha){
        return cozinhaRepository.findOneById(idCozinha);
    }

    @Transactional
    public void salvarCozinha(Cozinha cozinha){
        this.cozinhaRepository.save(cozinha);
    }

    @Transactional
    public void alterarCozinha(Long idCozinha, Cozinha cozinha){
        this.cozinhaRepository.update(idCozinha, cozinha.getNome());
    }

}
