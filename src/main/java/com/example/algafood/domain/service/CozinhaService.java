package com.example.algafood.domain.service;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.repository.CozinhaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;

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
    public void alterarCozinha(Cozinha cozinha){ this.cozinhaRepository.updateById(cozinha.getId(), cozinha.getNome()); }

    @Transactional
    public void deletarCozinha(Long idCozinha){
        cozinhaRepository.deleteById(idCozinha);
    }

}
