package br.edu.materdei.backend.controller;

import br.edu.materdei.backend.model.Resposta;
import br.edu.materdei.backend.model.ResultadoMediaTO;
import br.edu.materdei.backend.model.ResultadoTO;
import br.edu.materdei.backend.services.RespostaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("resposta")
public class RespostaController {
    
    @Autowired
    private RespostaService respostaService;
    
    
    @GetMapping
    public Iterable<Resposta> findAll() {
        return respostaService.findAll();
    }
    
    @PostMapping
    public List<ResultadoTO> save(@RequestBody Resposta resposta) {
        return respostaService.resultado( respostaService.save( resposta ).getId() );
    }

    @GetMapping("/{id}")
    public List<ResultadoTO> resultado(@PathVariable Long id) {
        return respostaService.resultado( id );
    }

    @GetMapping("/media-geral")
    public List<ResultadoMediaTO> media() {
        return respostaService.mediaResultado();
    }


}
