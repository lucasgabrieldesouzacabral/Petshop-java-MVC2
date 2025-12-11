package br.lil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import java.util.Objects;

import br.lil.dao.ServicoDao;
import br.lil.model.Servico;

@Service
public class ServicoService {
    private final ServicoDao servicoDao;

    public ServicoService(ServicoDao servicoDao) {
        this.servicoDao = servicoDao;
    }

    public List<Servico> listarTodos() {
        return servicoDao.findAll();
    }

    public Servico buscarPorId(int id) {
        return servicoDao.findById(id).orElse(null);
    }

    public void salvar(@NonNull Servico servico) {
        Objects.requireNonNull(servico);
        servicoDao.save(servico);
    }

    public void atualizar(Servico atualizado) {
        Servico servico = buscarPorId(atualizado.getIdServico());
    
        if (servico != null) {
            servico.setNomeItem(atualizado.getNomeItem());
            servico.setPrecoItem(atualizado.getPrecoItem());
            servico.setServicoHorario(atualizado.getServicoHorario());
            servico.setAnimal(atualizado.getAnimal());
            servico.setFuncionario(atualizado.getFuncionario());

            servicoDao.save(servico);
        }
    }

    public void excluir(int id) {
        servicoDao.deleteById(id);
    }
}