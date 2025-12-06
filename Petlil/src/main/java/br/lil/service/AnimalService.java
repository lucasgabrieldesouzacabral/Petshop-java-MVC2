package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.AnimalDao;
import br.ll.model.Animal;

@Service
public class AnimalService {

    @Autowired
    private AnimalDao animalDao;

    public List<Animal> listarTodos() {
        return animalDao.findAll();
    }

    public Animal salvar(Animal animal) {
        return animalDao.save(animal);
    }

    public void deletar(Long id) {
        animalDao.deleteById(id);
    }

    public Animal buscarPorId(Long id) {
        return animalDao.findById(id).orElse(null);
    }
}