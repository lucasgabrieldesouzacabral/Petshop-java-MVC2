package br.lil.spring_boot;

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

    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final PetshopService petshopService;

    public ProdutoController(ProdutoService produtoService, ClienteService clienteService, PetshopService petshopService) {
        this.produtoService = produtoService;
        this.clienteService = clienteService;
        this.petshopService = petshopService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaProdutos", produtoService.listarTodos());
        return "produtolista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("petshops", petshopService.listarTodos());
        return "produtocadastro";
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
        return "produtocadastro";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Produto produto) {
        produto.setIdProduto(id);
        produtoService.atualizar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "produtodetalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "produtoexcluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        produtoService.excluir(id);
        return "redirect:/produtos";
    }
}