package com.alugae.service;

import com.alugae.model.Imovel;
import com.alugae.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    // Injeção de dependência via construtor (boa prática recomendada no Spring)
    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public Imovel salvar(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public List<Imovel> listarTodos() {
        return imovelRepository.findAll();
    }

    public Optional<Imovel> buscarPorId(Long id) {
        return imovelRepository.findById(id);
    }

    public void deletar(Long id) {
        imovelRepository.deleteById(id);
    }
}