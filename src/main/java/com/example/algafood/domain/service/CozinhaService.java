package com.example.algafood.domain.service;

import com.example.algafood.domain.dto.CozinhaDTO;
import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.repository.CozinhaRepository;
import com.example.algafood.repository.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<CozinhaDTO> listarTodasCozinhas() throws BusinessException {
        try {

            List<Cozinha> cozinhas = cozinhaRepository.findAll();
            return cozinhas.stream()
                    .map(cozinha -> new CozinhaDTO(cozinha.getId(), cozinha.getNome()))
                    .collect(Collectors.toList());

        } catch (BusinessException e) {
            throw new BusinessException("Não foi possível listar todas as cozinhas");
        }
    }

    public CozinhaDTO buscarCozinhaId(Long idCozinha) throws BusinessException{
        try {

            Cozinha cozinha = cozinhaRepository.findOneById(idCozinha);

            if (Optional.ofNullable(cozinha).isEmpty()) {
                throw new BusinessException("Cozinha não encontrada");
            }

            return new CozinhaDTO(cozinha.getId(), cozinha.getNome());

        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }


    }

    @Transactional
    public void salvarCozinha(Cozinha cozinha){
        this.cozinhaRepository.save(cozinha);
    }

    @Transactional
    public void alterarCozinha(Cozinha cozinha) throws BusinessException{
        if (!cozinhaRepository.existsById(cozinha.getId())) {
            throw new BusinessException(String.format("Cozinha com ID %d não encontrada para atualização.", cozinha.getId()));
        }

        cozinhaRepository.updateById(cozinha.getId(), cozinha.getNome());
    }

    @Transactional
    public void deletarCozinha(Long idCozinha) throws BusinessException {

        Cozinha cozinha = cozinhaRepository.findById(idCozinha)
                .orElseThrow(() -> new BusinessException("Cozinha não encontrada"));

        cozinhaRepository.delete(cozinha);

    }

}
