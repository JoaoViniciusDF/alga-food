package com.example.algafood.controller;

import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Restaurante;
import com.example.algafood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/todos")
    public ResponseEntity<List<Object>> buscarTodosRestaurantes(){

        try{

            List<Restaurante> restaurantes = restauranteService.buscarTodosRestaurantes();

            if (restaurantes.isEmpty()){
                throw new BusinessException("Não existe restaurante!");
            }

            return ResponseEntity.ok(Collections.singletonList(restaurantes));

        }catch (BusinessException e){
            return ResponseEntity.internalServerError().body(Collections.singletonList(e.getMessage()));
        }

    }

    @GetMapping("/{idRestaurante}")
    public ResponseEntity<Object> buscarRestaurantePorId(@PathVariable("idRestaurante") Long idRestaurante){

        try {

            Restaurante restaurante = restauranteService.buscarRestaurantePorId(idRestaurante);

            if(Optional.ofNullable(restaurante).isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok().body(restaurante);

        }catch (BusinessException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
}
