package com.alugae.service;

import com.alugae.model.Imovel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Diz ao Spring que esta classe é um componente de serviço gerenciado por ele

public class ImovelService {
    
    // Lista centralizada de imóveis do Alugaê
    public List<Imovel> listarTodos() {
        List<Imovel> lista = new ArrayList<>();
        lista.add(new Imovel(1L, "Casa Beira-Mar com Wi-Fi", "Florianópolis", 350.00));
        lista.add(new Imovel(2L, "Apartamento no Centro", "Curitiba", 180.00));
        lista.add(new Imovel(3L, "Chácara com Piscina", "Gramado", 450.00));
        return lista;
    }

    // Lógica de filtro utilizando a nossa Stream API e Lambda
    public List<Imovel> filtrarPorPrecoMaximo(double precoMax) {
        return listarTodos().stream()
                .filter(imovel -> imovel.getPrecoPorNoite() <= precoMax)
                .toList();
    }
}
