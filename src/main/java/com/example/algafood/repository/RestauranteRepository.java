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

    public Restaurante findOneById(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_restaurante WHERE id_cozinha = :idCozinha", nativeQuery = true)
    void deleteByIdCozinha(@Param("idCozinha") Long idCozinha);

}
