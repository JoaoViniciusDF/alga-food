package com.example.algafood.repository;

import com.example.algafood.domain.model.Cozinha;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    public Cozinha findOneById(Long id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE algafood.tbl_cozinha SET nome=:nomeCozinha WHERE id=:idCozinha",
            nativeQuery = true)
    public void update(@Param("idCozinha") Long id, @Param("nomeCozinha") String nome);

}
