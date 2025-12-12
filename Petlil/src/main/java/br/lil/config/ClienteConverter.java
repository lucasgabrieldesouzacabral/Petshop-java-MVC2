package br.lil.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.lil.model.Cliente;
import br.lil.service.ClienteService;

@Component
public class ClienteConverter implements Converter<String, Cliente> {
    private final ClienteService clienteService;

    public ClienteConverter(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public Cliente convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        try {
            int clienteId = Integer.parseInt(id);
            return clienteService.buscarPorId(clienteId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
