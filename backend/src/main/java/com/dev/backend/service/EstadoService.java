package com.dev.backend.service;

import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado) {

        estado.setDataCriacao(new Date());
        Estado estadonovo = estadoRepository.saveAndFlush(estado);
        return estadonovo;

    }

    public Estado alterar(Estado estado) {
        estado.setDataAtuializacao(new Date());
        ;
        return estadoRepository.saveAndFlush(estado);

    }

    public void excluir(long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);

    }

}