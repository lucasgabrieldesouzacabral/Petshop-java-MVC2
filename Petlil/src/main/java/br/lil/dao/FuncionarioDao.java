package br.lil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.lil.model.Animal;

public interface FuncionarioDao extends JpaRepository<Funcionario, Long> {
    
}