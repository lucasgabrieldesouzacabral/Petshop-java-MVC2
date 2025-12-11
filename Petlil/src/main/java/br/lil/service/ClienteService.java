package br.lil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import java.util.Objects;
import br.lil.dao.ClienteDao;
import br.lil.model.Cliente;

@Service
public class ClienteService {
    private final ClienteDao clienteDao;

    public ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public List<Cliente> listarTodos() {
        return clienteDao.findAll();
    }

    public Cliente buscarPorId(int id) {
        return clienteDao.findById(id).orElse(null);
    }

    public void salvar(@NonNull Cliente cliente) {
        Objects.requireNonNull(cliente);
        clienteDao.save(cliente);
    }

    public void atualizar(Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(clienteAtualizado.getIdDonoAnimal());
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