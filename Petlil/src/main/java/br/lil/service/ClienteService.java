package br.lil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import br.lil.dao.ClienteDao;
import br.lil.model.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteDao clienteDao;
    private List<Cliente> clientes = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Cliente> listarTodos() {
        return clienteDao.findAll();
    }

    public Cliente buscarPorId(int id) {
        return clienteDao.findById(id).orElse(null);
    }

    public void salvar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    public void atualizar(Cliente clienteAtualizado) {
        Cliente cliente = findById(clienteAtualizado.getIdDonoAnimal());
        if (cliente != null) {
            cliente.setDonoNome(clienteAtualizado.getDonoNome());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setTelefone(clienteAtualizado.getTelefone());

            clienteDao.save(cliente);
        }
    }

    public void excluir(int id) {
        clienteDao.deleteById(id);
    }
}