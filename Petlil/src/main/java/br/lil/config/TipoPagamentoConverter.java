package br.lil.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.lil.model.TipoPagamento;
import br.lil.service.TipoPagamentoService;

@Component
public class TipoPagamentoConverter implements Converter<String, TipoPagamento> {
    private final TipoPagamentoService tipoPagamentoService;

    public TipoPagamentoConverter(TipoPagamentoService tipoPagamentoService) {
        this.tipoPagamentoService = tipoPagamentoService;
    }

    @Override
    public TipoPagamento convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        try {
            int tipoId = Integer.parseInt(id);
            return tipoPagamentoService.buscarPorId(tipoId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
