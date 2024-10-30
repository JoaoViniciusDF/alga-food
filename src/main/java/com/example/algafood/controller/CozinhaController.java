package com.example.algafood.controller;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaService cozinhaService;

    @GetMapping("/listarCozinhas")
    private List<Cozinha> listarCozinhas(){

        return cozinhaService.listarTodasCozinhas();

    }

}
