package br.lil.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.lil.model.Animal;
import br.lil.service.AnimalService;

@Component
public class AnimalConverter implements Converter<String, Animal> {
    private final AnimalService animalService;

    public AnimalConverter(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public Animal convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        try {
            int animalId = Integer.parseInt(id);
            return animalService.buscarPorId(animalId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
