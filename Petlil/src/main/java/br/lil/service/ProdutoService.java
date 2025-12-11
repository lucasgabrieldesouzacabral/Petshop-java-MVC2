package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lil.dao.ProdutoDao;
import br.lil.model.Produto;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoDao produtoDao;
    private List<Produto> produtos = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Produto> listarTodos() {
        return produtoDao.findAll();
    }

    public Produto buscarPorId(int id) {
        return produtoDao.findById(id).orElse(null);
    }

    public void salvar(Produto produto) {
        produtoDao.save(produto);
    }

    public void atualizar(Produto pAtualizado) {
        Produto produto = buscarPorId(pAtualizado.getIdProduto());
    
        if (produto != null) {
            produto.setNomeItem(pAtualizado.getnomeItem());
            produto.setPrecoItem(pAtualizado.getprecoItem());
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