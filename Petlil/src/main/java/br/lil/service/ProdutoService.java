package br.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ll.dao.ProdutoDao;
import br.ll.model.Produto;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    private int autoIncrement = 1;

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getIdProduto() == id)
                .findFirst()
                .orElse(null);
    }

    public void salvar(Produto produto) {
        produto.setIdProduto(autoIncrement++);
        produtos.add(produto);
    }

    public void atualizar(Produto pAtualizado) {
        Produto p = buscarPorId(pAtualizado.getIdProduto());

        if (p != null) {
            p.setNomeItem(pAtualizado.getnomeItem());
            p.setPrecoItem(pAtualizado.getprecoItem());
            p.setDescricao(pAtualizado.getDescricao());
            p.setCliente(pAtualizado.getCliente());
            p.setPetshop(pAtualizado.getPetshop());
        }
    }

    public void excluir(int id) {
        produtos.removeIf(p -> p.getIdProduto() == id);
    }
}