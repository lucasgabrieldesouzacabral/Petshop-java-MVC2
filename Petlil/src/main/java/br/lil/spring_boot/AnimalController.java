package br.ll.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ll.service.AnimalService;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animais")
    public String listarAnimais(Model model) {
        model.addAttribute("listaAnimais", animalService.listarTodos());
        return "animal";
    }
}