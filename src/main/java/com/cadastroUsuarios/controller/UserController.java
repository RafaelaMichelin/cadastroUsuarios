package com.cadastroUsuarios.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;




import com.cadastroUsuarios.model.User;
import com.cadastroUsuarios.repository.UserRepository;


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
    public ModelAndView salvar(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(user);
        }  
        userRepository.save(user);
        return cadastrar(new User());
    }

      //Listagem 
    @GetMapping("/listarUser")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("principal/lista");
        mv.addObject("listarUser", userRepository.findAll());
        return mv;
    }

     //Editar
    @GetMapping("/editarUser/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
         Optional<User> user = userRepository.findById(id);
         return cadastrar(user.get());
    }

    //Excluir 
    @GetMapping("/excluirUser/{id}")
    public ModelAndView excluir(@PathVariable("id")Long id){
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
        return listar();
    }

}
