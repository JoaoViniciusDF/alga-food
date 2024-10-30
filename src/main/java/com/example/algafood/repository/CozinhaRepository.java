package com.example.algafood.repository;

import com.example.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    public Cozinha findOneById(Long id);

}
