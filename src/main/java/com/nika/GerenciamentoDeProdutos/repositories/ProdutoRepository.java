package com.nika.GerenciamentoDeProdutos.repositories;

import com.nika.GerenciamentoDeProdutos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

    ProdutoModel findBynome(String nome);
    UserDetails findByLogin(String role);
}
