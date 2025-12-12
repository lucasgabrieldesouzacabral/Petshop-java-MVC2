package br.lil.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.lil.model.Servico;
import br.lil.service.ServicoService;

@Component
public class ServicoConverter implements Converter<String, Servico> {
    private final ServicoService servicoService;

    public ServicoConverter(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @Override
    public Servico convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        try {
            int servicoId = Integer.parseInt(id);
            return servicoService.buscarPorId(servicoId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
