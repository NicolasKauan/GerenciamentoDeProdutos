package com.nika.GerenciamentoDeProdutos.controller;


import com.nika.GerenciamentoDeProdutos.model.ProdutoModel;
import com.nika.GerenciamentoDeProdutos.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // 201 criou a bagaça com sucesso
    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto){
        ProdutoModel salvo = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    //200 beleza conseguiu retornar a lista
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar(){
        List<ProdutoModel> produtos = service.listar();
        return ResponseEntity.ok(produtos);
    }

    // 200 conseguiu encontrar ou 404 de fudeu não achei
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscar(@PathVariable UUID id){
        ProdutoModel produto = service.buscar(id);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<ProdutoModel> buscarNome(@PathVariable String nome){
        ProdutoModel produto = service.BuscarNome(nome);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    //204 apagou com sucesso rapaziada
    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoModel> deletar(@PathVariable UUID id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
