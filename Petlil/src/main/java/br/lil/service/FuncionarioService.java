package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.FuncionarioDao;
import br.ll.model.Funcionario;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioDao funcionarioDao;
    private List<Funcionario> funcionarios = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Funcionario> listarTodos() {
        return funcionarioDao.findAll();
    }

    public Funcionario buscarPorId(int id) {
        return funcionarioDao.findById(id).orElse(null);
    }

    public void salvar(Funcionario funcionario) {
        funcionarioDao.save(funcionario);
    }

    public void atualizar(Funcionario atualizado) {
        Funcionario funcionario = buscarPorId(atualizado.getId());

        if (funcionario != null) {
            funcionario.setNomeFuncionario(atualizado.getNomeFuncionario());
            funcionario.setFuncao(atualizado.getFuncao());
            funcionario.setSalario(atualizado.getSalario());

            funcionarioDao.save(funcionario);
        }
    }

    public void excluir(int id) {
        funcionarioDao.deleteById(id);
    }
}