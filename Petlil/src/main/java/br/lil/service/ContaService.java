package br.lil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lil.dao.ContaDao;
import br.lil.model.Conta;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaDao contaDao;
    public List<Conta> listarTodas() {
        return contaDao.findAll();
    }

    public Conta buscarPorId(int id) {
        return contaDao.findById(id).orElse(null);
    }

    public void salvar(Conta conta) {
        contaDao.save(conta);
    }

    public void atualizar(Conta atualizada) {
        Conta existente = buscarPorId(atualizada.getIdCompra());

        if (existente != null) {
            existente.setPagamento(atualizada.getPagamento());
            existente.setAtendente(atualizada.getAtendente());
            existente.setTipoPagamento(atualizada.getTipoPagamento());
            existente.setCliente(atualizada.getCliente());
            contaDao.save(existente);
        }
    }

    public void excluir(int id) {
        contaDao.deleteById(id);
    }
}