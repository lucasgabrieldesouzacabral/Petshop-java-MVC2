package br.lil.spring_boot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import br.lil.model.Conta;
import br.lil.model.Produto;
import br.lil.model.Servico;
import br.lil.service.ContaService;
import br.lil.service.ClienteService;
import br.lil.service.AnimalService;
import br.lil.service.FuncionarioService;
import br.lil.service.ProdutoService;
import br.lil.service.ServicoService;
import br.lil.service.TipoPagamentoService;

@Controller
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;
    private final ClienteService clienteService;
    private final AnimalService animalService;
    private final FuncionarioService funcionarioService;
    private final ProdutoService produtoService;
    private final ServicoService servicoService;
    private final TipoPagamentoService tipoPagamentoService;

    public ContaController(ContaService contaService,
                        ClienteService clienteService,
                        AnimalService animalService,
                        FuncionarioService funcionarioService,
                        ProdutoService produtoService,
                        ServicoService servicoService,
                        TipoPagamentoService tipoPagamentoService) {
        this.contaService = contaService;
        this.clienteService = clienteService;
        this.animalService = animalService;
        this.funcionarioService = funcionarioService;
        this.produtoService = produtoService;
        this.servicoService = servicoService;
        this.tipoPagamentoService = tipoPagamentoService;
    }

    @GetMapping
    public String listarContas(Model model) {
        model.addAttribute("listaContas", contaService.listarTodas());
        return "contalista";
    }

    @GetMapping("/novo")
    public String novaContaForm(Model model) {
        model.addAttribute("conta", new Conta());

        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("animais", animalService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        model.addAttribute("produtos", produtoService.listarTodos());
        model.addAttribute("servicos", servicoService.listarTodos());
        model.addAttribute("tiposPagamento", tipoPagamentoService.listarTodos());

        return "contacadastro";
    }

    @PostMapping
    public String salvarConta(@ModelAttribute Conta conta,
                            @RequestParam(required = false) List<Integer> produtosSelecionados,
                            @RequestParam(required = false) List<Integer> servicosSelecionados) {

        double total = 0;

        if (produtosSelecionados != null) {
            for (Integer id : produtosSelecionados) {
                Produto p = produtoService.buscarPorId(id);
                total += p.getPrecoItem();
            }
        }

        if (servicosSelecionados != null) {
            for (Integer id : servicosSelecionados) {
                Servico s = servicoService.buscarPorId(id);
                total += s.getPrecoItem();
            }
        }

        conta.setPagamento(total);
        contaService.salvar(conta);

        return "redirect:/contas";
    }

    @GetMapping("/editar/{id}")
    public String editarConta(@PathVariable int id, Model model) {
        model.addAttribute("conta", contaService.buscarPorId(id));
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("animais", animalService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        model.addAttribute("produtos", produtoService.listarTodos());
        model.addAttribute("servicos", servicoService.listarTodos());
        model.addAttribute("tiposPagamento", tipoPagamentoService.listarTodos());
        return "contacadastro";
    }

    @PostMapping("/editar/{id}")
    public String atualizarConta(@PathVariable int id, @ModelAttribute Conta conta,
                                @RequestParam(required = false) List<Integer> produtosSelecionados,
                                @RequestParam(required = false) List<Integer> servicosSelecionados) {
        double total = 0;
        if (produtosSelecionados != null) {
            for (Integer pid : produtosSelecionados) {
                Produto p = produtoService.buscarPorId(pid);
                total += p.getPrecoItem();
            }
        }
        if (servicosSelecionados != null) {
            for (Integer sid : servicosSelecionados) {
                Servico s = servicoService.buscarPorId(sid);
                total += s.getPrecoItem();
            }
        }
        conta.setIdCompra(id);
        conta.setPagamento(total);
        contaService.atualizar(conta);
        return "redirect:/contas";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("conta", contaService.buscarPorId(id));
        return "contadetalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("conta", contaService.buscarPorId(id));
        return "contaexcluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        contaService.excluir(id);
        return "redirect:/contas";
    }
}