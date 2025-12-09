package br.ll.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ll.model.Animal;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
    
}