package br.lil.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.lil.model.Servico;
import br.lil.service.AnimalService;
import br.lil.service.FuncionarioService;
import br.lil.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService servicoService;
    private final AnimalService animalService;
    private final FuncionarioService funcionarioService;

    public ServicoController(ServicoService servicoService, AnimalService animalService, FuncionarioService funcionarioService) {
        this.servicoService = servicoService;
        this.animalService = animalService;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaServicos", servicoService.listarTodos());
        return "servicolista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("animais", animalService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "servicocadastro";
    }

    @PostMapping
    public String salvar(@ModelAttribute Servico servico) {
        servicoService.salvar(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("servico", servicoService.buscarPorId(id));
        model.addAttribute("animais", animalService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "servicocadastro";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Servico servico) {
        servico.setIdServico(id);
        servicoService.atualizar(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("servico", servicoService.buscarPorId(id));
        return "servicodetalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("servico", servicoService.buscarPorId(id));
        return "servicoexcluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        servicoService.excluir(id);
        return "redirect:/servicos";
    }
}