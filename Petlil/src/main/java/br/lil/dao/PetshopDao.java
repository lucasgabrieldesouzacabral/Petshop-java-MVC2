package br.lil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.lil.model.Petshop;

public interface PetshopDao extends JpaRepository<Petshop, Integer> {

}
