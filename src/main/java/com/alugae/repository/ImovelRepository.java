package com.alugae.repository;

import com.alugae.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    // Não precisa escrever nada aqui dentro por enquanto!
    // O JpaRepository já traz todos os métodos prontos: salvar, listar, buscar por ID e deletar.
}
