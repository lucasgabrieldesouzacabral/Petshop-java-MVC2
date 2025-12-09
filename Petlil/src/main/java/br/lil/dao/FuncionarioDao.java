package br.ll.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ll.model.Animal;

public interface FuncionarioDao extends JpaRepository<Funcionario, Long> {
    
}