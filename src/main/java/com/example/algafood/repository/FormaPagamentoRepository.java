package com.example.algafood.repository;

import com.example.algafood.domain.model.Cozinha;
import com.example.algafood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

    public Cozinha findOneById(Long id);

}
