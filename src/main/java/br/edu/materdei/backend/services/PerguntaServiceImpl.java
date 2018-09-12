package br.edu.materdei.backend.services;

import br.edu.materdei.backend.data.PerguntaData;
import br.edu.materdei.backend.model.Pergunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerguntaServiceImpl implements PerguntaService {

    @Autowired 
    private PerguntaData perguntaData;
    
    @Override
    public Iterable<Pergunta> findAll() {
        return perguntaData.findAll();
    }
    
}
