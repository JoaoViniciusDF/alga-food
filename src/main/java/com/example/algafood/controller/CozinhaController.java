package com.example.algafood.controller;

import com.example.algafood.domain.dto.CozinhaDTO;
import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaService cozinhaService;

    @GetMapping("/todos")
    public ResponseEntity<List<Object>> listarCozinhas(){
        try{

            List<CozinhaDTO> cozinhas = cozinhaService.listarTodasCozinhas();

            if (cozinhas.isEmpty()) {
                throw new BusinessException("Não existe cozinha!");
            }

            return ResponseEntity.ok(Collections.singletonList(cozinhas));

        }catch (BusinessException e){
            return ResponseEntity.internalServerError().body(Collections.singletonList(e.getMessage()));
        }
    }

    @GetMapping("/{idCozinha}")
    public ResponseEntity<Object> buscarCozinhaId(@PathVariable("idCozinha") Long idCozinha){
        try{

            CozinhaDTO cozinha = cozinhaService.buscarCozinhaId(idCozinha);

            if(Optional.ofNullable(cozinha).isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(cozinha);

        }catch (BusinessException e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> salvarCozinha(@RequestBody CozinhaDTO cozinha){
        try {

            cozinhaService.salvarCozinha(cozinha);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }

    @PutMapping("/{idCozinha}")
    public ResponseEntity<Object> updateCozinha(@RequestBody CozinhaDTO cozinha, @PathVariable("idCozinha") Long idCozinha){
        try {

            cozinha.setId(idCozinha);
            cozinhaService.alterarCozinha(cozinha);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idCozinha}")
    public ResponseEntity<Object> deletarCozinha(@PathVariable("idCozinha") Long idCozinha){
        try {

            cozinhaService.deletarCozinha(idCozinha);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}
