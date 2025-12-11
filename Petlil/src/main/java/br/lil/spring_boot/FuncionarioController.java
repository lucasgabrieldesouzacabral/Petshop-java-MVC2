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

import br.lil.model.Funcionario;
import br.lil.model.Animal;
import br.lil.service.FuncionarioService;
import br.lil.service.AnimalService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaFuncionarios", funcionarioService.listarTodos());
        return "funcionario-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionario-form";
    }

    @PostMapping("/atualizar/{id}")
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
            .filter(a -> a.getFuncionarioAtendido() != null &&
                         a.getFuncionarioAtendido().getId() == id)
            .toList();

        model.addAttribute("animaisAtendidos", atendidos);

        return "funcionario-detalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagina(@PathVariable int id, Model model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionario-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        funcionarioService.excluir(id);
        return "redirect:/funcionarios";
    }
}