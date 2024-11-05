package com.example.algafood.domain.service;

import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.repository.CozinhaRepository;
import com.example.algafood.repository.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

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
    public void alterarCozinha(Cozinha cozinha){
        try {

            cozinhaRepository.updateById(cozinha.getId(), cozinha.getNome());

        }catch (BusinessException e){
            throw new BusinessException(String.format("Não foi possivel alterar a cozinha id: %d. Motivo: %s",
                    cozinha.getId(), e.getMessage()));
        }
    }

    @Transactional
    public void deletarCozinha(Long idCozinha){
        try {

            restauranteRepository.deleteByIdCozinha(idCozinha);
            cozinhaRepository.deleteById(idCozinha);

        }catch (BusinessException e){
            throw new BusinessException(String.format("Não foi possivel alterar a cozinha id: %d. Motivo: %s",
                    idCozinha, e.getMessage()));
        }
    }

}
