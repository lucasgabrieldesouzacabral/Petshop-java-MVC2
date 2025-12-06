package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.ServicoDao;
import br.ll.model.Servico;

@Service
public class ServicoService {

    private List<Servico> servicos = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Servico> listarTodos() {
        return servicos;
    }

    public Servico buscarPorId(int id) {
        return servicos.stream()
            .filter(s -> s.getIdServico() == id)
            .findFirst()
            .orElse(null);
    }

    public void salvar(Servico servico) {
        servico.setIdServico(autoIncrement++);
        servicos.add(servico);
    }

    public void atualizar(Servico atualizado) {
        Servico s = buscarPorId(atualizado.getIdServico());

        if (s != null) {
            s.setNomeItem(atualizado.getnomeItem());
            s.setPrecoItem(atualizado.getprecoItem());
            s.setServicoHorario(atualizado.getServicoHorario());
            s.setAnimal(atualizado.getAnimal());
            s.setFuncionario(atualizado.getFuncionario());
        }
    }

    public void excluir(int id) {
        servicos.removeIf(s -> s.getIdServico() == id);
    }
}