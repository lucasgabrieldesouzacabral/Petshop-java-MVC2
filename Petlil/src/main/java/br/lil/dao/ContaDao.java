package br.lil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.lil.model.Conta;

public interface ContaDao extends JpaRepository<Conta, Integer> {
}