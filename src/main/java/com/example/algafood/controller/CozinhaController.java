package com.example.algafood.controller;

import com.example.algafood.domain.exception.BusinessException;
import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaService cozinhaService;

    @GetMapping("/todos")
    public ResponseEntity<List<Cozinha>> listarCozinhas() throws Exception {
        try{

            List<Cozinha> cozinhas = cozinhaService.listarTodasCozinhas();

            if (cozinhas.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(cozinhas);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/{idCozinha}")
    public ResponseEntity<Optional<Cozinha>> buscarCozinhaId(@PathVariable("idCozinha") Long idCozinha) throws Exception {
        try{

            Optional<Cozinha> cozinha = Optional.ofNullable(cozinhaService.buscarCozinhaId(idCozinha));

            if(cozinha.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(cozinha);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> salvarCozinha(@RequestBody Cozinha cozinha) throws Exception {
        try {

            cozinhaService.salvarCozinha(cozinha);
            return ResponseEntity.noContent().build();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @PutMapping("/{idCozinha}")
    public ResponseEntity<Object> updateCozinha(@RequestBody Cozinha cozinha, @PathVariable("idCozinha") Long idCozinha) throws Exception {
        try {

            cozinha.setId(idCozinha);
            cozinhaService.alterarCozinha(cozinha);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idCozinha}")
    public ResponseEntity<Object> deletarCozinha(@PathVariable("idCozinha") Long idCozinha) throws BusinessException {
        try {

            cozinhaService.deletarCozinha(idCozinha);
            return ResponseEntity.noContent().build();

        }catch (BusinessException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}
