package com.cadastroUsuarios.controller;
import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PrincipalController {
@GetMapping("/principal")

public String acessarPrincipal(){
    return "principal/home";
    
}
}
