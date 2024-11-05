package com.example.algafood.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDTO {

    private Long id;

    @NotNull(message = "O nome do restaurante não pode ser nulo.")
    private String nome;

    @NotNull(message = "A taxa de frete não pode ser nula.")
    private BigDecimal taxaFrete;

    private CozinhaDTO cozinha;
}
