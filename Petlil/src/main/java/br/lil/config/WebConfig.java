package br.lil.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ClienteConverter clienteConverter;
    private final FuncionarioConverter funcionarioConverter;
    private final PetshopConverter petshopConverter;
    private final TipoPagamentoConverter tipoPagamentoConverter;
    private final AnimalConverter animalConverter;
    private final ServicoConverter servicoConverter;

    public WebConfig(ClienteConverter clienteConverter,
                    FuncionarioConverter funcionarioConverter,
                    PetshopConverter petshopConverter,
                    TipoPagamentoConverter tipoPagamentoConverter,
                    AnimalConverter animalConverter,
                    ServicoConverter servicoConverter) {
        this.clienteConverter = clienteConverter;
        this.funcionarioConverter = funcionarioConverter;
        this.petshopConverter = petshopConverter;
        this.tipoPagamentoConverter = tipoPagamentoConverter;
        this.animalConverter = animalConverter;
        this.servicoConverter = servicoConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(clienteConverter);
        registry.addConverter(funcionarioConverter);
        registry.addConverter(petshopConverter);
        registry.addConverter(tipoPagamentoConverter);
        registry.addConverter(animalConverter);
        registry.addConverter(servicoConverter);
    }
}
