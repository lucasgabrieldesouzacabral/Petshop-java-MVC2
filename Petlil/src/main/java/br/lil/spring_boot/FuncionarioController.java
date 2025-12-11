package br.lil.spring_boot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.lil.model.Funcionario;
import br.lil.model.Animal;
import br.lil.service.FuncionarioService;
import br.lil.service.AnimalService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final AnimalService animalService;

    public FuncionarioController(FuncionarioService funcionarioService, AnimalService animalService) {
        this.funcionarioService = funcionarioService;
        this.animalService = animalService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaFuncionarios", funcionarioService.listarTodos());
        return "funcionariolista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionariocadastro";
    }

    @PostMapping
    public String salvar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionariocadastro";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Funcionario funcionario) {
        funcionario.setId(id);
        funcionarioService.atualizar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {

        Funcionario f = funcionarioService.buscarPorId(id);
        model.addAttribute("funcionario", f);

        List<Animal> atendidos = animalService.listarTodos()
            .stream()
            .filter(a -> a.getfuncionarioatendido() != null &&
                a.getfuncionarioatendido().getId() == id)
            .collect(java.util.stream.Collectors.toList());

        model.addAttribute("animaisAtendidos", atendidos);

        return "funcionariodetalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionarioexcluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        funcionarioService.excluir(id);
        return "redirect:/funcionarios";
    }
}