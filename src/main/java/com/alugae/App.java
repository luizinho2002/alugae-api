package com.alugae;

import com.alugae.model.Imovel;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Imovel> listaDeImoveis = new ArrayList<>();
        listaDeImoveis.add(new Imovel(1L, "Casa Beira-Mar", "Florianópolis", 350.00));
        listaDeImoveis.add(new Imovel(2L, "Apto no Centro", "Curitiba", 180.00));
        listaDeImoveis.add(new Imovel(3L, "Mansão de Luxo", "São Paulo", 1200.00));

        System.out.println("=== IMÓVEIS ABAIXO DE R$ 400 ===");

        // Utilizando Stream API e Lambda
        listaDeImoveis.stream()
            .filter(imovel -> imovel.getPrecoPorNoite() < 400) // Filta os imóveis
            .forEach(imovel -> imovel.exibirDetalhes());       // Exibe os filtrados
    }
}