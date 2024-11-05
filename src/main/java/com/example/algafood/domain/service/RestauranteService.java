package com.example.algafood.domain.service;

import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Restaurante;
import com.example.algafood.repository.RestauranteRepository;
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
}
