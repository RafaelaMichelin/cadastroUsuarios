package com.cadastroUsuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cadastroUsuarios.repository.UserRepository;
import com.cadastroUsuarios.model.User;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/cadastroUser")
    public ModelAndView cadastrar(User user){
            ModelAndView mv = new ModelAndView("principal/cadastro");
            mv.addObject("user", user);
            return mv;
    }

    
     //Salvar 
    @PostMapping("/salvarUser")
    public ModelAndView salvar(User user, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(user);
        }  
        userRepository.save(user);
        return cadastrar(new User());
    }
}
