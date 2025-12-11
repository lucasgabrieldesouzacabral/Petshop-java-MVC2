package br.lil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import java.util.Objects;
    
import br.lil.dao.FuncionarioDao;
import br.lil.model.Funcionario;

@Service
public class FuncionarioService {
    private final FuncionarioDao funcionarioDao;

    public FuncionarioService(FuncionarioDao funcionarioDao) {
        this.funcionarioDao = funcionarioDao;
    }

    public List<Funcionario> listarTodos() {
        return funcionarioDao.findAll();
    }

    public Funcionario buscarPorId(int id) {
        return funcionarioDao.findById(id).orElse(null);
    }

    public void salvar(@NonNull Funcionario funcionario) {
        Objects.requireNonNull(funcionario);
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