package tw.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.loja.data.Utilizador;
//import tw.loja.services.RegistoService;
import tw.loja.services.UtilizadorService;

import java.security.Principal;


@Controller
public class MainController {
    @Autowired
    private UtilizadorService utilizadorService;

    //@Autowired
    //private RegistoService registoService;

    @GetMapping("/")
    public String home(Model model) {
        //model.addAttribute("ultimosRegistos", registoService.getUltimosRegistos());
        return "index";
    }

    @GetMapping(value = "/advanced_search")
    public String advanced_search(Principal principal){
        System.out.println("Teste1:"+ principal);
        if(principal == null)
            return "advanced_search";
        else
            return "index";
    }


    @GetMapping(value = "/login")
    public String login(Principal principal){
        System.out.println("Teste1:"+ principal);
        if(principal == null)
            return "login";
        else
            return "index";
    }


    @GetMapping(value = "/join")
    public String joinGet(Model model) {
        Utilizador novo = new Utilizador();
        model.addAttribute("Utilizador", novo);
        return "join";
    }

    @PostMapping(value = "/join")
    public String joinPost(@ModelAttribute("Utilizador") Utilizador utilizador) {
        if(utilizadorService.createUtilizador(utilizador.getUsername(), utilizador.getPassword(), utilizador.getEmail()))
            return "login";
        return "join";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}