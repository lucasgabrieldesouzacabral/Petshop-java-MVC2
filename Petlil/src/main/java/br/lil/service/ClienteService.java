package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.ClienteDao;
import br.ll.model.Cliente;

@Service
public class ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    public List<Cliente> listarTodos() {
        return clienteDao.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    public void deletar(Long id) {
        clienteDao.deleteById(id);
    }
}