package com.nika.GerenciamentoDeProdutos.services;

import com.nika.GerenciamentoDeProdutos.model.ProdutoModel;
import com.nika.GerenciamentoDeProdutos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoModel salvar(ProdutoModel produto){
        return repository.save(produto);
    }

    public List<ProdutoModel> listar(){
        return repository.findAll();
    }

    public ProdutoModel buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
