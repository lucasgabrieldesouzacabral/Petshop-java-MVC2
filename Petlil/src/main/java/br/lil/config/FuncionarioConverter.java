package br.lil.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.lil.model.Funcionario;
import br.lil.service.FuncionarioService;

@Component
public class FuncionarioConverter implements Converter<String, Funcionario> {
    private final FuncionarioService funcionarioService;

    public FuncionarioConverter(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @Override
    public Funcionario convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        try {
            int funcionarioId = Integer.parseInt(id);
            return funcionarioService.buscarPorId(funcionarioId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
