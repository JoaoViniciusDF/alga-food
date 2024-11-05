package com.example.algafood.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CozinhaDTO {

    private Long id;

    @NotNull(message = "O nome da cozinha não pode ser nulo.")
    private String nome;
}
