package br.lil.spring_boot;

 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.lil.model.Animal;
import br.lil.service.AnimalService;
import br.lil.service.ClienteService;
import br.lil.service.FuncionarioService;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    public AnimalController(AnimalService animalService, ClienteService clienteService, FuncionarioService funcionarioService) {
        this.animalService = animalService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaAnimais", animalService.listarTodos());
        return "animallista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("listaClientes", clienteService.listarTodos());
        model.addAttribute("listaFuncionarios", funcionarioService.listarTodos());
        return "animalcadastro";
    }

    @PostMapping
    public String salvar(@ModelAttribute("animal") Animal animal) {
        animalService.salvar(animal);
        return "redirect:/animais";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.buscarPorId(id));
        model.addAttribute("listaClientes", clienteService.listarTodos());
        model.addAttribute("listaFuncionarios", funcionarioService.listarTodos());
        return "animalcadastro";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute("animal") Animal animal) {
        animal.setIdAnimal(id);
        animalService.atualizar(animal);
        return "redirect:/animais";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.buscarPorId(id));
        return "animaldetalhes";
    }

    @GetMapping("/excluir/{id}")
    public String paginaExcluir(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.buscarPorId(id));
        return "animalexcluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        animalService.excluir(id);
        return "redirect:/animais";
    }
}