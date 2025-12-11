package br.lil.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaServicos", servicoService.listarTodos());
        return "servico-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("animais", animalService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "servico-form";
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
        return "servico-form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Servico servico) {
        servico.setIdServico(id);
        servicoService.atualizar(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("servico", servicoService.buscarPorId(id));
        return "servico-detalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("servico", servicoService.buscarPorId(id));
        return "servico-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        servicoService.excluir(id);
        return "redirect:/servicos";
    }
}