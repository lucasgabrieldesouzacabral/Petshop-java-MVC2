package br.lil.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.lil.model.Cliente;
import br.lil.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaClientes", clienteService.listarTodos());
        return "cliente-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @PostMapping
    public String salvar(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "cliente-form";
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
        return "cliente-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        clienteService.excluir(id);
        return "redirect:/clientes";
    }
}