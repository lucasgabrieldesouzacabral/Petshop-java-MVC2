package br.lil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.lil.model.TipoPagamento;

public interface TipoPagamentoDao extends JpaRepository<TipoPagamento, Integer> {

}
