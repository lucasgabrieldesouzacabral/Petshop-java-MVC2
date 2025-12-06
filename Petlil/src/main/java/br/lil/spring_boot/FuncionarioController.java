package br.ll.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ll.service.FuncionarioService;

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

    @PostMapping
    public String salvar(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionario-form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute("funcionario") Funcionario funcionario) {
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
                .filter(a -> a.getfuncionarioatendido() != null && a.getfuncionarioatendido().getId() == id)
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