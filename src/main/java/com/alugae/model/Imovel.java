package com.alugae.model;

import java.util.HashSet;
import java.util.Set;

public class Imovel {

    private Long id;
    private String titulo;
    private String cidade;
    private double precoPorNoite;
    private Set<String> comodidades; // Lista de comodidades únicas

    public Imovel(Long id, String titulo, String cidade, double precoPorNoite) {
        this.id = id;
        this.titulo = titulo;
        this.cidade = cidade;
        this.id = id;
        this.precoPorNoite = precoPorNoite;
        this.comodidades = new HashSet<>(); // Inicializa o Set vazio
    }

    // Método para adicionar comodidade (se já existir, o Set ignora e não duplica!)
    public void adicionarComodidade(String comodidade) {
        this.comodidades.add(comodidade);
    }

    public void exibirDetalhes() {
        System.out.println("ID: " + id + "Imóvel: " + titulo + " | Cidade: " + cidade + " | R$ " + precoPorNoite + " /noite");
        System.out.println("Comodidades: " + comodidades);
        System.out.println("--------------------------------------------------");
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCidade() {
        return cidade;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }
}
