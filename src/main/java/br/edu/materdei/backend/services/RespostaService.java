package br.edu.materdei.backend.services;

import br.edu.materdei.backend.model.Resposta;
import br.edu.materdei.backend.model.ResultadoMediaTO;
import br.edu.materdei.backend.model.ResultadoTO;
import java.util.List;


public interface RespostaService {
    
    Iterable<Resposta> findAll();
    
    Resposta save(Resposta resposta);

    List<ResultadoTO> resultado(Long id);

    List<ResultadoMediaTO> mediaResultado();

}

