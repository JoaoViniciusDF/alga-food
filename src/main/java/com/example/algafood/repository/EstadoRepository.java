package com.example.algafood.repository;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public Cozinha findOneById(Long id);

}
