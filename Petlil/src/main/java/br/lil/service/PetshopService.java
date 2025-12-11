package br.lil.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.lil.dao.PetshopDao;
import br.lil.model.Petshop;

@Service
public class PetshopService {
    private final PetshopDao petshopDao;

    public PetshopService(PetshopDao petshopDao) {
        this.petshopDao = petshopDao;
    }

    public List<Petshop> listarTodos() {
        return petshopDao.findAll();
    }

    public Petshop buscarPorId(int id) {
        return petshopDao.findById(id).orElse(null);
    }

    public void salvar(Petshop petshop) {
        petshopDao.save(petshop);
    }

    public void atualizar(Petshop atualizado) {
        Petshop existente = buscarPorId(atualizado.getIdPetshop());
        if (existente != null) {
            existente.setNome(atualizado.getNome());
            existente.setEndereco(atualizado.getEndereco());
            petshopDao.save(existente);
        }
    }

    public void excluir(int id) {
        petshopDao.deleteById(id);
    }
}
