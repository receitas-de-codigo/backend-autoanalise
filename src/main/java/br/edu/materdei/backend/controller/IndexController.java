package br.edu.materdei.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    @GetMapping("teste")
    public String testarAcesso() {
        return "OK";
    }
    
}
