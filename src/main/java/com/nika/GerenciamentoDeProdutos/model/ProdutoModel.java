package com.nika.GerenciamentoDeProdutos.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "Produtos")
@Table(name = "tb_produtos")
public class ProdutoModel {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NomeProduto")
    private String nome;

    @Column(name = "PrecoProduto")
    private BigDecimal preco;

    @Column(name = "EstoqueProduto")
    private Integer estoque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
