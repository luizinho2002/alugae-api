package com.alugae.controller;

import com.alugae.model.Imovel;
import com.alugae.service.ImovelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController 
public class AlugaeController {

    // 1. Declaramos o serviço como final (garante imutabilidade)
    private final ImovelService imovelService;

    // 2. Criamos o construtor. Nas versões modernas do Spring Boot, se a classe tem apenas um construtor, o @Autowired não é mais obrigatório aqui!
    public AlugaeController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping("/")
    public String home() {
        return "Bem-vindo ao Alugaê! A sua API Spring Boot está online e funcionando!";
    }

    @GetMapping("/imoveis")
    public List<Imovel> listarImoveis() {
        return imovelService.listarTodos();
    }

    @GetMapping("/imoveis/filtrar")
    public List<Imovel> filtrarImoveis(@RequestParam double precoMax) {
        return imovelService.filtrarPorPrecoMaximo(precoMax);
    }
}




    
