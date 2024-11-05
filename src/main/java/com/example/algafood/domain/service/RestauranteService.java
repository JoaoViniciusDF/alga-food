package com.example.algafood.domain.service;

import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.model.Restaurante;
import com.example.algafood.repository.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;


    public List<Restaurante> buscarTodosRestaurantes() throws BusinessException{
        try {
            return restauranteRepository.findAll();
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel buscar todos os restaurantes");
        }

    }

    public Restaurante buscarRestaurantePorId(Long id) throws BusinessException{
        try {
            return restauranteRepository.findOneById(id);
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel consulta o restaurante por id.");
        }
    }

    @Transactional
    public void salvarRestaurante(Restaurante restaurante){
        this.restauranteRepository.save(restaurante);
    }

    @Transactional
    public void alterarRestaurante(Restaurante restaurante) throws BusinessException{
        if (!restauranteRepository.existsById(restaurante.getId())) {
            throw new BusinessException(String.format("Cozinha com ID %d não encontrada para atualização.", restaurante.getId()));
        }

        restauranteRepository.updateById(restaurante.getId(), restaurante.getNome());
    }

    @Transactional
    public void deletarRestaurante(Long idRestaurante) throws BusinessException{

        Restaurante restaurante = restauranteRepository.findById(idRestaurante)
                .orElseThrow(() -> new BusinessException("Restaurante não encontrada"));

        restauranteRepository.delete(restaurante);

    }


}
