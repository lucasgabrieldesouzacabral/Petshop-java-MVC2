package br.lil.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ContaService contaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ServicoService servicoService;
    @Autowired
    private TipoPagamentoService tipoPagamentoService;

    @GetMapping
    public String listarContas(Model model) {
        model.addAttribute("contas", contaService.listarTodas());
        return "conta-lista";
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

        return "conta-form";
    }

    @PostMapping("/salvar")
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

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("conta", contaService.buscarPorId(id));
        return "conta-detalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("conta", contaService.buscarPorId(id));
        return "conta-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        contaService.excluir(id);
        return "redirect:/contas";
    }
}