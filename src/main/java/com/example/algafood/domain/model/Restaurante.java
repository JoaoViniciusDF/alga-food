package com.example.algafood.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbl_restaurante")
public class Restaurante {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @NotNull(message = "${entity.notnull.message}")
    @JoinColumn(name = "id_cozinha")
    private Cozinha cozinha;

    @NotNull(message = "${entity.notnull.message}")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "${entity.notnull.message}")
    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

}
