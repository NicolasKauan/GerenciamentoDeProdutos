package com.nika.GerenciamentoDeProdutos.services;

import com.nika.GerenciamentoDeProdutos.model.ProdutoModel;
import com.nika.GerenciamentoDeProdutos.repositories.ProdutoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService implements UserDetailsService {

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

    public ProdutoModel buscar(UUID id){
        return repository.findById(id).orElse(null);
    }

    public void deletar(UUID id){
        repository.deleteById(id);
    }

    public ProdutoModel BuscarNome(String nome){
        return repository.findBynome(nome);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }gi
}
