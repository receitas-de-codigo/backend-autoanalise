package br.edu.materdei.backend.services;

import br.edu.materdei.backend.model.Pergunta;


public interface PerguntaService {
    
    Iterable<Pergunta> findAll();
    
}
