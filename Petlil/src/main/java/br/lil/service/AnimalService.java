package br.lil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import java.util.Objects;

import br.lil.dao.AnimalDao;
import br.lil.model.Animal;

@Service
public class AnimalService {
    private final AnimalDao animalDao;

    public AnimalService(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public List<Animal> listarTodos() {
        return animalDao.findAll();
    }

    public Animal buscarPorId(int id) {
        return animalDao.findById(id).orElse(null);
    }

    public void salvar(@NonNull Animal animal) {
        Objects.requireNonNull(animal);
        animalDao.save(animal);
    }

    public void atualizar(Animal atualizado) {
        Animal existente = buscarPorId(atualizado.getIdAnimal());

        if (existente != null) {
            existente.setNomeAnimal(atualizado.getNomeAnimal());
            existente.setIdadeAnimal(atualizado.getIdadeAnimal());
            existente.setEspecieAnimal(atualizado.getEspecieAnimal());
            existente.setRacaAnimal(atualizado.getRacaAnimal());
            existente.setPesoAnimal(atualizado.getPesoAnimal());
            existente.setIdDonoAnimal(atualizado.getidDonoAnimal());
            existente.setfuncionarioatendido(atualizado.getfuncionarioatendido());
        }
    }

    public void excluir(int id) {
        animalDao.deleteById(id);
    }
}