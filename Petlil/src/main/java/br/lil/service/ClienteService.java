package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.ClienteDao;
import br.ll.model.Cliente;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        return clientes.stream()
                .filter(c -> c.getIdDonoAnimal() == id)
                .findFirst()
                .orElse(null);
    }

    public void salvar(Cliente cliente) {
        cliente.setIdDonoAnimal(autoIncrement++);
        clientes.add(cliente);
    }

    public void atualizar(Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(clienteAtualizado.getIdDonoAnimal());
        if (cliente != null) {
            cliente.setDonoNome(clienteAtualizado.getDonoNome());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setTelefone(clienteAtualizado.getTelefone());
        }
    }

    public void excluir(int id) {
        clientes.removeIf(c -> c.getIdDonoAnimal() == id);
    }
}