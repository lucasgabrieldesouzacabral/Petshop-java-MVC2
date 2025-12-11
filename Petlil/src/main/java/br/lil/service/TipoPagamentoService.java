package br.lil.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.lil.dao.TipoPagamentoDao;
import br.lil.model.TipoPagamento;

@Service
public class TipoPagamentoService {
    private final TipoPagamentoDao tipoPagamentoDao;

    public TipoPagamentoService(TipoPagamentoDao tipoPagamentoDao) {
        this.tipoPagamentoDao = tipoPagamentoDao;
    }

    public List<TipoPagamento> listarTodos() {
        return tipoPagamentoDao.findAll();
    }

    public TipoPagamento buscarPorId(int id) {
        return tipoPagamentoDao.findById(id).orElse(null);
    }

    public void salvar(TipoPagamento t) {
        tipoPagamentoDao.save(t);
    }

    public void atualizar(TipoPagamento atualizado) {
        TipoPagamento existente = buscarPorId(atualizado.getIdPagamento());
        if (existente != null) {
            existente.setNomePagamento(atualizado.getNomePagamento());
            tipoPagamentoDao.save(existente);
        }
    }

    public void excluir(int id) {
        tipoPagamentoDao.deleteById(id);
    }
}
