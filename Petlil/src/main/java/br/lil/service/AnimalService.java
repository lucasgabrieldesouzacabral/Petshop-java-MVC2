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
    private List<Animal> animais = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Animal> listarTodos() {
        return animalDao.findAll();
    }

    public Animal buscarPorId(int id) {
        return animalDao.findById(id).orElse(null);
    }

    public void salvar(Animal animal) {
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
            existente.setDono(atualizado.getDono());
            existente.setfuncionarioatendido(atualizado.getfuncionarioatendido());
        }
    }

    public void excluir(int id) {
        animaiDao.deleteById(id);
    }
}