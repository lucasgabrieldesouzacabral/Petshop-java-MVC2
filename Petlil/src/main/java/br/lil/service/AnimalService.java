package br.lil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import br.lil.dao.AnimalDao;
import br.lil.model.Animal;

@Service
public class AnimalService {
    @Autowired
    private AnimalDao AnimalDao;
    private List<Animal> animais = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Animal> listarTodos() {
        return AnimalDao.findAll();
    }

    public Animal buscarPorId(int id) {
        return AnimalDao.findById(id).orElse(null);
    }

    public void salvar(Animal animal) {
       AnimalDao.save(animal);
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
        AnimalDao.deleteById(id);
    }
}