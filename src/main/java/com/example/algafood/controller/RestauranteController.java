package com.example.algafood.controller;

import com.example.algafood.domain.dto.RestauranteDTO;
import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

            List<RestauranteDTO> restaurantes = restauranteService.buscarTodosRestaurantes();

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

            RestauranteDTO restaurante = restauranteService.buscarRestaurantePorId(idRestaurante);

            if(Optional.ofNullable(restaurante).isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok().body(restaurante);

        }catch (BusinessException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> salvarCozinha(@RequestBody RestauranteDTO restaurante){
        try {

            restauranteService.salvarRestaurante(restaurante);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }

    @PutMapping("/{idCozinha}")
    public ResponseEntity<Object> updateCozinha(@RequestBody RestauranteDTO restaurante, @PathVariable("idCozinha") Long idRestaurante){
        try {

            restaurante.setId(idRestaurante);
            restauranteService.alterarRestaurante(restaurante);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idCozinha}")
    public ResponseEntity<Object> deletarCozinha(@PathVariable("idCozinha") Long idRestaurante){
        try {

            restauranteService.deletarRestaurante(idRestaurante);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
