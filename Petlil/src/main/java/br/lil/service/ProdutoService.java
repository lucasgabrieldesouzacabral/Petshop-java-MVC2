package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.ProdutoDao;
import br.ll.model.Produto;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    public List<Produto> listarTodos() {
        return produtoDao.findAll();
    }

    public Produto salvar(Produto produto) {
        return produtoDao.save(produto);
    }

    public void deletar(Long id) {
        produtoDao.deleteById(id);
    }
}