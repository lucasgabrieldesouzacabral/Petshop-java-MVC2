package br.lil.service;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import java.util.Objects;

import br.lil.dao.ContaDao;
import br.lil.model.Conta;

import java.util.List;

@Service
public class ContaService {

    private final ContaDao contaDao;
    public ContaService(ContaDao contaDao) {
        this.contaDao = contaDao;
    }

    public List<Conta> listarTodas() {
        return contaDao.findAll();
    }

    public Conta buscarPorId(int id) {
        return contaDao.findById(id).orElse(null);
    }

    public void salvar(@NonNull Conta conta) {
        Objects.requireNonNull(conta);
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