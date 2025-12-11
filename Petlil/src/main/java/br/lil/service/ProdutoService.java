package br.lil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import java.util.Objects;

import br.lil.dao.ProdutoDao;
import br.lil.model.Produto;

@Service
public class ProdutoService {
    private final ProdutoDao produtoDao;

    public ProdutoService(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public List<Produto> listarTodos() {
        return produtoDao.findAll();
    }

    public Produto buscarPorId(int id) {
        return produtoDao.findById(id).orElse(null);
    }

    public void salvar(@NonNull Produto produto) {
        Objects.requireNonNull(produto);
        produtoDao.save(produto);
    }

    public void atualizar(Produto pAtualizado) {
        Produto produto = buscarPorId(pAtualizado.getIdProduto());
    
        if (produto != null) {
            produto.setNomeItem(pAtualizado.getNomeItem());
            produto.setPrecoItem(pAtualizado.getPrecoItem());
            produto.setDescricao(pAtualizado.getDescricao());
            produto.setCliente(pAtualizado.getCliente());
            produto.setPetshop(pAtualizado.getPetshop());

            produtoDao.save(produto);
        }
    }

    public void excluir(int id) {
        produtoDao.deleteById(id);
    }
}