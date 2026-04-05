package com.nika.GerenciamentoDeProdutos.repositories;

import com.nika.GerenciamentoDeProdutos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
