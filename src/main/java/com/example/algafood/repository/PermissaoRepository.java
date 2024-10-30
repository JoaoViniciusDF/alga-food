package com.example.algafood.repository;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    public Cozinha findOneById(Long id);

}
