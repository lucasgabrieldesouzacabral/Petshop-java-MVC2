package br.ll.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ll.model.Conta;

public interface ContaDao extends JpaRepository<Conta, Integer> {
}