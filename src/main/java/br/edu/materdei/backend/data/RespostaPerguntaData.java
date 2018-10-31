package br.edu.materdei.backend.data;

import br.edu.materdei.backend.model.RespostaPergunta;
import br.edu.materdei.backend.model.RespostaPerguntaProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RespostaPerguntaData extends CrudRepository<RespostaPergunta, Long> {

    @Query(value = "SELECT avg(PONTOS) as PONTOS, PERGUNTA_ID as ID, P.PERGUNTA as PERGUNTA FROM RESPOSTA_PERGUNTA " +
            "left join PERGUNTA P on P.ID = PERGUNTA_ID " +
            "GROUP BY PERGUNTA_ID", nativeQuery = true)
    List<RespostaPerguntaProjection> getMediaRespostas();

}
