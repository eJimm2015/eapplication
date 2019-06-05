package fr.dauphine.eappli.controller;


import fr.dauphine.eappli.model.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

    @GetMapping("/subscribe")
    public ModelAndView subscribe(){
        ModelAndView modelAndView = new ModelAndView("subscribe");
        modelAndView.addObject("user", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/subscribe")
    public String subscription(@ModelAttribute("user") @Valid UserDTO user, BindingResult result){
        if(result.hasErrors()) return "subscribe";
     //   serviceProvider.addUser(user);
        return "redirect:subscribe?good";
    }
}
