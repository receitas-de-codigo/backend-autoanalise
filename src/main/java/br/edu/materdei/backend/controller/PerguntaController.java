package br.edu.materdei.backend.controller;

import br.edu.materdei.backend.model.Pergunta;
import br.edu.materdei.backend.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pergunta")
public class PerguntaController {
    
    @Autowired
    private PerguntaService perguntaService;
    
    @GetMapping
    public Iterable<Pergunta> findAll() {
        return perguntaService.findAll();
    }
     
}
