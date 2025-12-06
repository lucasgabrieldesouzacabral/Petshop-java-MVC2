package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.FuncionarioDao;
import br.ll.model.Funcionario;

@Service
public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }

    public Funcionario buscarPorId(int id) {
        return funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void salvar(Funcionario funcionario) {
        funcionario.setId(autoIncrement++);
        funcionarios.add(funcionario);
    }

    public void atualizar(Funcionario atualizado) {
        Funcionario f = buscarPorId(atualizado.getId());

        if (f != null) {
            f.setNomeFuncionario(atualizado.getNomeFuncionario());
            f.setFuncao(atualizado.getfuncao());
            f.setSalario(atualizado.getsalario());
        }
    }

    public void excluir(int id) {
        funcionarios.removeIf(f -> f.getId() == id);
    }
}