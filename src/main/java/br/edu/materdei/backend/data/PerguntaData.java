package br.edu.materdei.backend.data;

import br.edu.materdei.backend.model.Pergunta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerguntaData extends CrudRepository<Pergunta, Long> {


    @Query("select p from Pergunta p where p.ativo = 1")
    List<Pergunta> findAllAtivas();

}
