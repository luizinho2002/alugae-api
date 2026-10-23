package com.alugae.controller;

import com.alugae.model.Imovel;
import com.alugae.service.ImovelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imoveis")
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
    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarPorId(@PathVariable Long id) {
        Optional<Imovel> imovel = imovelService.buscarPorId(id);

        if (imovel.isPresent()) {
            return ResponseEntity.ok(imovel.get()); // Retorna 200 OK com o imóvel
        }
        return ResponseEntity.notFound().build(); // Retorna 404 se não achar
    }

    // POST: Cadastrar novo imóvel (/imoveis)
    @PostMapping
    public ResponseEntity<Imovel> cadastrar(@RequestBody Imovel imovel) {
        Imovel novoImovel = imovelService.salvar(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoImovel); // Retorna 201 Created
    }

    // DELETE: Deletar imóvel por ID (/imoveis/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Imovel> imovel = imovelService.buscarPorId(id);

        if (imovel.isPresent()) {
            imovelService.deletar(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        }
        return ResponseEntity.notFound().build(); // // Retorna 404 se não existir
    }
}