package com.alugae.service;

import com.alugae.model.Imovel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Diz ao Spring que esta classe é um componente de serviço gerenciado por ele
public class ImovelService {

    // Lista salva na memória da aplicação
    private final List<Imovel> imoveis = new ArrayList<>();

    // Construtor: Inicializa com 3 imóveis padrão para não começar vazia
    public ImovelService() {
        imoveis.add(new Imovel(1L, "Casa Beira-Mar com Wi-Fi", "Florianópolis", 350.00));
        imoveis.add(new Imovel(2L, "Apartamento no Centro", "Curitiba", 180.00));
        imoveis.add(new Imovel(3L, "Chácara com Piscina", "Gramado", 450.00));
    }

    // 1. READ: Listar todos
    public List<Imovel> listarTodos() {
        return imoveis;
    }

    // 2. READ: Buscar por ID
    public Optional<Imovel> buscarPorId(Long id) {
        return imoveis.stream()
                .filter(imovel -> imovel.getId().equals(id))
                .findFirst();
    }

    // 3. READ: Filtrar por preço máximo
    public List<Imovel> filtrarPorPrecoMaximo(double precoMax) {
        return imoveis.stream()
                .filter(imovel -> imovel.getPrecoPorNoite() <= precoMax)
                .toList();

    }

    // 4. CREATE: Cadastrar novo imóvel
    public Imovel cadastrar(Imovel novoImovel) {
        imoveis.add(novoImovel);
        return novoImovel;
    }

    // 5. DELETE: Remover imóvel por ID
    public boolean deletar(Long id) {
        return imoveis.removeIf(imovel -> imovel.getId().equals(id));
    }

}