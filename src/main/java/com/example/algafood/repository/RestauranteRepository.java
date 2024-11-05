package com.example.algafood.repository;

import com.example.algafood.domain.model.Restaurante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_restaurante SET nome=:nomeRestaurante WHERE id=:idRestaurante",
            nativeQuery = true)
    public void updateById(@Param("idRestaurante") Long id, @Param("nomeRestaurante") String nome);

}
