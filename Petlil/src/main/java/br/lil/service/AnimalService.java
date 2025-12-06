package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.AnimalDao;
import br.ll.model.Animal;

@Service
public class AnimalService {

    private List<Animal> animais = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Animal> listarTodos() {
        return animais;
    }

    public Animal buscarPorId(int id) {
        return animais.stream()
                .filter(a -> a.getIdAnimal() == id)
                .findFirst()
                .orElse(null);
    }

    public void salvar(Animal animal) {
        animal.setIdAnimal(autoIncrement++);
        animais.add(animal);

       
        if (animal.getDono() != null) {
            animal.getDono().adicionarAnimal(animal);
        }
    }

    public void atualizar(Animal atualizado) {
        Animal a = buscarPorId(atualizado.getIdAnimal());

        if (a != null) {
            a.setNomeAnimal(atualizado.getNomeAnimal());
            a.setIdadeAnimal(atualizado.getIdadeAnimal());
            a.setEspecieAnimal(atualizado.getEspecieAnimal());
            a.setRacaAnimal(atualizado.getRacaAnimal());
            a.setPesoAnimal(atualizado.getPesoAnimal());
            a.setDono(atualizado.getDono());
            a.setfuncionarioatendido(atualizado.getfuncionarioatendido());
        }
    }

    public void excluir(int id) {
        animais.removeIf(a -> a.getIdAnimal() == id);
    }
}