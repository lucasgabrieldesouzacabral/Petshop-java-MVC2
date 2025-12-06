package br.ll.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ll.service.FuncionarioService;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
        model.addAttribute("listaFuncionarios", funcionarioService.listarTodos());
        return "funcionario";
    }
}