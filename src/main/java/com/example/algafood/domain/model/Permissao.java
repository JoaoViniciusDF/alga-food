package com.example.algafood.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "${entity.notnull.message}")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "${entity.notnull.message}")
    @Column(name = "ds_descricao")
    private String descricao;

}
