package br.lil.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.lil.model.Petshop;
import br.lil.service.PetshopService;

@Component
public class PetshopConverter implements Converter<String, Petshop> {
    private final PetshopService petshopService;

    public PetshopConverter(PetshopService petshopService) {
        this.petshopService = petshopService;
    }

    @Override
    public Petshop convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        try {
            int petshopId = Integer.parseInt(id);
            return petshopService.buscarPorId(petshopId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
