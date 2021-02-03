package tw.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import tw.loja.data.Utilizador;
import org.springframework.web.servlet.resource.PathResourceResolver;
//import tw.loja.services.RegistoService;
import tw.loja.security.StaticResourceConfiguration;
import tw.loja.services.UtilizadorService;

import java.security.Principal;


@Controller
public class MainController extends StaticResourceConfiguration {


    @Autowired
    private UtilizadorService utilizadorService;

    //@Autowired
    //private RegistoService registoService;

    @GetMapping(value="/")
    public String home(Model model) {
        //model.addAttribute("ultimosRegistos", registoService.getUltimosRegistos());
        return "index";
    }


    @GetMapping(value = "/login")
    public String login(Principal principal){
        if(principal == null)
            return "login";
        else
            return home(null);
    }

    @GetMapping(value = "/join")
    public String joinGet(Model model) {
        Utilizador novo = new Utilizador();
        model.addAttribute("Utilizador", novo);
        return "join";
    }

    @PostMapping(value = "/join")
    public String joinPost(@ModelAttribute("Utilizador") Utilizador utilizador) {
        if(utilizadorService.createUtilizador(utilizador.getUsername(), utilizador.getPassword()))
            return "login";
        return "join";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}