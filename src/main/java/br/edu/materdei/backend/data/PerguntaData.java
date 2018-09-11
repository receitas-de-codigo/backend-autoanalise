package br.edu.materdei.backend.data;

import br.edu.materdei.backend.model.Pergunta;
import org.springframework.data.repository.CrudRepository;


public interface PerguntaData extends CrudRepository<Pergunta, Long> {
    
}
