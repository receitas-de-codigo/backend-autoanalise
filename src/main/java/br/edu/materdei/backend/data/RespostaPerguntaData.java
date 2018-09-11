package br.edu.materdei.backend.data;

import br.edu.materdei.backend.model.RespostaPergunta;
import org.springframework.data.repository.CrudRepository;


public interface RespostaPerguntaData extends CrudRepository<RespostaPergunta, Long> {
    
}
