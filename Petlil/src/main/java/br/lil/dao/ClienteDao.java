package br.lil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.lil.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}
