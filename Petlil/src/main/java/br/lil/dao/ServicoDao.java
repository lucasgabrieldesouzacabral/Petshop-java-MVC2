package br.lil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.lil.model.Servico;

public interface ServicoDao extends JpaRepository<Servico, Integer> {
    
}