package br.lil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lil.dao.ServicoDao;
import br.lil.model.Servico;

@Service
public class ServicoService {
    @Autowired
    private ServicoDao servicoDao;
    private List<Servico> servicos = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Servico> listarTodos() {
        return servicoDao.findAll();
    }

    public Servico buscarPorId(int id) {
        return servicoDao.findById(id).orElse(null);
    }

    public void salvar(Servico servico) {
        servicoDao.save(servico);
    }

    public void atualizar(Servico atualizado) {
        Servico servico = buscarPorId(atualizado.getIdServico());
    
        if (servico != null) {
            servico.setNomeItem(atualizado.getnomeItem());
            servico.setPrecoItem(atualizado.getprecoItem());
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