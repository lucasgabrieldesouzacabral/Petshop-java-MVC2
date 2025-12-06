package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.ServicoDao;
import br.ll.model.Servico;

@Service
public class ServicoService {

    @Autowired
    private ServicoDao servicoDao;

    public List<Servico> listarTodos() {
        return servicoDao.findAll();
    }

    public Servico salvar(Servico servico) {
        return servicoDao.save(servico);
    }

    public void deletar(Long id) {
        servicoDao.deleteById(id);
    }
}