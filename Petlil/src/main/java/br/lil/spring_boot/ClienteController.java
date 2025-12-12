package br.lil.spring_boot;

 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.lil.model.Cliente;
import br.lil.model.Animal;
import br.lil.service.ClienteService;
import br.lil.service.AnimalService;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final AnimalService animalService;

    public ClienteController(ClienteService clienteService, AnimalService animalService) {
        this.clienteService = clienteService;
        this.animalService = animalService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaClientes", clienteService.listarTodos());
        return "clientelista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientecadastro";
    }

    @PostMapping
    public String salvar(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "clientecadastro";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        
        List<Animal> animaisDoCliente = animalService.listarTodos()
            .stream()
            .filter(a -> a.getIdDonoAnimal() != null && a.getIdDonoAnimal().getIdDonoAnimal() == id)
            .collect(Collectors.toList());
        
        model.addAttribute("animaisDoCliente", animaisDoCliente);
        return "clientedetalhes";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute("cliente") Cliente cliente) {
        cliente.setIdDonoAnimal(id);
        clienteService.atualizar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/excluir/{id}")
    public String paginaExcluir(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "clienteexcluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        clienteService.excluir(id);
        return "redirect:/clientes";
    }
}