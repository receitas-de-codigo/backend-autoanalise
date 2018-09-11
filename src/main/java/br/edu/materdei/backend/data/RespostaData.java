package br.edu.materdei.backend.data;

import br.edu.materdei.backend.model.Resposta;
import org.springframework.data.repository.CrudRepository;

public interface RespostaData extends CrudRepository<Resposta, Long> {
    
}
