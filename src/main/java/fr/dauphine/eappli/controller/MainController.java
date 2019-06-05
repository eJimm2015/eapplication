package fr.dauphine.eappli.controller;


import fr.dauphine.eappli.model.UserDTO;
import fr.dauphine.eappli.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private ServiceProvider provider;

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }


    @GetMapping("/subscribe")
    public ModelAndView subscribe(){
        ModelAndView modelAndView = new ModelAndView("subscribe");
        modelAndView.addObject("user", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/subscribe")
    public String subscription(@ModelAttribute("user") @Valid UserDTO user, BindingResult result){
        if(result.hasErrors()) return "subscribe";
        provider.addUser(user.toDomainObject());
        return "redirect:subscribe?good";
    }
}
