package com.example.algafood.repository;

import com.example.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    public Restaurante findOneById(Long id);

}
