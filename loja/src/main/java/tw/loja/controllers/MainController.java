package tw.loja.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.loja.data.Produto;
import tw.loja.data.Utilizador;
//import tw.loja.services.RegistoService;
import tw.loja.security.StaticResourceConfiguration;
import tw.loja.services.ProdutoService;
import tw.loja.services.UtilizadorService;

import java.security.Principal;
import java.util.List;


@Controller
public class MainController extends StaticResourceConfiguration {


    @Autowired
    private UtilizadorService utilizadorService;
    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value="/")
    public String home(Model model, @Param("keyword") String keyword) {
        List<Produto> listProducts = produtoService.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/advanced_search")
    public String advancedSearch1(Model model) {
            Produto novo = new Produto();
            model.addAttribute("Produto", novo);
            return "advanced_search";
    }

    @RequestMapping(value = "/advanced_search")
    public String advancedSearch(Model model,@ModelAttribute("Produto") Produto produto,@Param("marca") String marca, @Param("cor") String cor, @Param("fuel") String fuel) {

        marca = produto.getMarca();
        cor = produto.getCor();
        fuel = produto.getFuel();
        List<Produto> listProducts = produtoService.findProduto(cor, marca, fuel);
        model.addAttribute("listProducts", listProducts);
        return "index";

    }

    @GetMapping(value="/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/productdisplay")
    public String product1(Model model) {
        Produto novo = new Produto();
        model.addAttribute("Produto", novo);
        return "productdisplay";
    }

    @RequestMapping(value="/productdisplay/{id}")
    public String product(Model model,@PathVariable(name = "id") Long id) {
        List<Produto> listProducts = produtoService.findByIdProduto(id);
        model.addAttribute("listProducts", listProducts);
        return "productdisplay";
    }



    @GetMapping("/admin")
    public String getUsers(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            Produto novo = new Produto();
            model.addAttribute("Produto", novo);
            return "admin";
        }else{
            return "/";
        }
    }

    @PostMapping(value = "/admin")
    public String admninPost(@ModelAttribute("Produto") Produto produto) {
        if(produtoService.createProduto(produto.getId(),produto.getNome(),produto.getPreco(),produto.getCor(), produto.getMarca(), produto.getFuel(),produto.getTipo()))
            return "admin";
        else
            return "/";
    }


    @GetMapping(value = "/login")
    public String login(Principal principal){
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

    @RequestMapping(value="/delete")
    public String delete(Model model, @Param("keyword") String keyword) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            List<Produto> listProducts = produtoService.listAll(keyword);
            model.addAttribute("listProducts", listProducts);
            model.addAttribute("keyword", keyword);
            return "/delete";
        }else{
            return "/";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        produtoService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}