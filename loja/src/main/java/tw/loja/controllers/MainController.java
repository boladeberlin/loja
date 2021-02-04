package tw.loja.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class MainController extends StaticResourceConfiguration {


    @Autowired
    private UtilizadorService utilizadorService;

    //@Autowired
    //private RegistoService registoService;

    @GetMapping(value="/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping(value="/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping(value="/advanced_search")
    public String search(Model model) {
        return "advanced_search";
    }

    @GetMapping(value="/productdisplay")
    public String product(Model model) {
        return "productdisplay";
    }



    @GetMapping("/admin")
    public String getUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "admin";
        }else{
            return "index";
        }
    }


    @GetMapping(value = "/login")
    public String login(Principal principal){
        System.out.println(principal);
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
        if(utilizadorService.createUtilizador(utilizador.getUsername(), utilizador.getPassword()))
            return "login";
        return "join";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}