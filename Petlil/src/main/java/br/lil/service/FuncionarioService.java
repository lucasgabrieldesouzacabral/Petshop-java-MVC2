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

    public List<Funcionario> listarTodos() {
        return funcionarioDao.findAll();
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioDao.save(funcionario);
    }

    public void deletar(Long id) {
        funcionarioDao.deleteById(id);
    }
}