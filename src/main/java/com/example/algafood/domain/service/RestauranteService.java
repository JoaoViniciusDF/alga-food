package com.example.algafood.domain.service;

import com.example.algafood.domain.dto.CozinhaDTO;
import com.example.algafood.domain.dto.RestauranteDTO;
import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.model.Restaurante;
import com.example.algafood.repository.CozinhaRepository;
import com.example.algafood.repository.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;


    private Restaurante toEntity(RestauranteDTO restauranteDTO) {

        if (restauranteDTO == null) {
            throw new IllegalArgumentException("RestauranteDTO não pode ser nulo");
        }

        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteDTO.getNome());
        restaurante.setTaxaFrete(restauranteDTO.getTaxaFrete());

        if (restauranteDTO.getCozinha() == null || restauranteDTO.getCozinha().getId() == null) {
            throw new BusinessException("Cozinha não pode ser nula ou deve ter um ID válido.");
        }

        Cozinha cozinha = cozinhaRepository.findById(restauranteDTO.getCozinha().getId())
                .orElseThrow(() -> new BusinessException("Cozinha não encontrada para ID: " + restauranteDTO.getCozinha().getId()));

        restaurante.setCozinha(cozinha);

        return restaurante;
    }

    private RestauranteDTO toDto(Restaurante restaurante) {

        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getTaxaFrete(),
                new CozinhaDTO(restaurante.getCozinha().getId(), restaurante.getCozinha().getNome())
        );

    }

    private List<RestauranteDTO> toDtoList(List<Restaurante> restaurantes) {

        return restaurantes.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    @Transactional
    public void salvarRestaurante(RestauranteDTO restaurante){
        this.restauranteRepository.save(toEntity(restaurante));
    }

    @Transactional
    public void alterarRestaurante(RestauranteDTO restaurante) throws BusinessException{

        if (!restauranteRepository.existsById(restaurante.getId())) {
            throw new BusinessException(String.format("Cozinha com ID %d não encontrada para atualização.", restaurante.getId()));
        }

        restauranteRepository.updateById(restaurante.getId(), restaurante.getNome());

    }

    @Transactional
    public void deletarRestaurante(Long idRestaurante) throws BusinessException{

        Restaurante restaurante = restauranteRepository.findById(idRestaurante)
                .orElseThrow(() -> new BusinessException("Restaurante não encontrado"));

        restauranteRepository.delete(restaurante);

    }

    public RestauranteDTO buscarRestaurantePorId(Long idRestaurante) throws BusinessException {

        Restaurante restaurante = restauranteRepository.findById(idRestaurante)
                .orElseThrow(() -> new BusinessException("Restaurante não encontrado"));

        return toDto(restaurante);

    }

    public List<RestauranteDTO> buscarTodosRestaurantes() throws BusinessException{
        try {

            List<Restaurante> restaurantes = restauranteRepository.findAll();
            return toDtoList(restaurantes);

        } catch (Exception e) {
            throw new BusinessException("Não foi possível listar todos os restaurantes.");
        }
    }

}
