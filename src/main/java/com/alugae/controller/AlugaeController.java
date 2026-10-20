package com.alugae.controller;

import com.alugae.model.Imovel;
import com.alugae.service.ImovelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController 
@RequestMapping("/imoveis") // Define a rota base para este controller
public class AlugaeController {

    private final ImovelService imovelService;

    public AlugaeController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    // GET: Listar todos (/imoveis)
    @GetMapping
    public List<Imovel> listarTodos() {
        return imovelService.listarTodos();
    }

    // GET: Buscar por ID (/imoveis/1)
    @GetMapping("/filtrar")
    public List<Imovel> filtrarImoveis(@RequestParam double precoMax) {
        return imovelService.filtrarPorPrecoMaximo(precoMax);
    }

    // POST: Cadastrar novo imóvel (/imoveis)
    @PostMapping
    public ResponseEntity<Imovel> cadastrar(@RequestBody Imovel imovel) {
        Imovel novoImovel = imovelService.cadastrar(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoImovel); // Devolve status 201 Created!
    }

    // DELETE: Deletar imóvel por ID (/imoveis/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = imovelService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build(); // Status 204 No Content
        }
        return ResponseEntity.notFound().build(); // Status 404 Not Found
    }
}




    
