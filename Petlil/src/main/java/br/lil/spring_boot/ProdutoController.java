package br.lil.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.lil.model.Produto;
import br.lil.service.ProdutoService;
import br.lil.service.ClienteService;
import br.lil.service.PetshopService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PetshopService petshopService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaProdutos", produtoService.listarTodos());
        return "produto-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("petshops", petshopService.listarTodos());
        return "produto-form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("petshops", petshopService.listarTodos());
        return "produto-form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Produto produto) {
        produto.setIdProduto(id);
        produtoService.atualizar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "produto-detalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "produto-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        produtoService.excluir(id);
        return "redirect:/produtos";
    }
}