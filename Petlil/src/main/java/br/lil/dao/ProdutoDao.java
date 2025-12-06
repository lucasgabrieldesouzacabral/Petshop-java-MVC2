package br.ll.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ll.model.Animal;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Long> {
    
}