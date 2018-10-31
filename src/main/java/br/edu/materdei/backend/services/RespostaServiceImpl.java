package br.edu.materdei.backend.services;

import br.edu.materdei.backend.data.RespostaData;
import br.edu.materdei.backend.data.RespostaPerguntaData;
import br.edu.materdei.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired private RespostaData data;
    @Autowired private RespostaPerguntaData respostaPerguntaData;
    
    @Override
    public Iterable<Resposta> findAll() {
        return data.findAll();
    }

    @Override
    public Resposta save(Resposta resposta) {
        resposta.getLsRespostas().forEach(item -> item.setResposta(resposta));
        return data.save(resposta);
    }

    @Override
    public List<ResultadoMediaTO> mediaResultado() {
        List<ResultadoMediaTO> ls = new ArrayList<>();

        List<RespostaPerguntaProjection> mediaRespostas = respostaPerguntaData.getMediaRespostas();

        Float fatorCorrecao = calcularFatorDeCorrecao(mediaRespostas);

        calcularOportunidades(ls, mediaRespostas, fatorCorrecao);
        calcularPersistencia(ls, mediaRespostas, fatorCorrecao);
        calcularComprometimento(ls, mediaRespostas, fatorCorrecao);
        calcularExigencia(ls, mediaRespostas, fatorCorrecao);
        calcularRiscos(ls, mediaRespostas, fatorCorrecao);
        calcularMetas(ls, mediaRespostas, fatorCorrecao);
        calcularBusca(ls, mediaRespostas, fatorCorrecao);
        calcularPlanejamento(ls, mediaRespostas, fatorCorrecao);
        calcularPersuasao(ls, mediaRespostas, fatorCorrecao);
        calcularIndependencia(ls, mediaRespostas, fatorCorrecao);

        return ls;
    }

    @Override
    public List<ResultadoTO> resultado(Long id) {
        Optional<Resposta> resposta = data.findById( id );

        List<ResultadoTO> ls = new ArrayList<>();

        Integer fatorCorrecao = calcularFatorDeCorrecao(resposta.get());

        calcularOportunidades(ls, resposta.get(), fatorCorrecao);
        calcularPersistencia(ls, resposta.get(), fatorCorrecao);
        calcularComprometimento(ls, resposta.get(), fatorCorrecao);
        calcularExigencia(ls, resposta.get(), fatorCorrecao);
        calcularRiscos(ls, resposta.get(), fatorCorrecao);
        calcularMetas(ls, resposta.get(), fatorCorrecao);
        calcularBusca(ls, resposta.get(), fatorCorrecao);
        calcularPlanejamento(ls, resposta.get(), fatorCorrecao);
        calcularPersuasao(ls, resposta.get(), fatorCorrecao);
        calcularIndependencia(ls, resposta.get(), fatorCorrecao);

        return ls;
    }



    private void calcularOportunidades(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 1L) + get(res, 12L) + get(res, 23L) - get(res, 34L) + get(res, 45L) + 6;
        adicionar(ls, "Busca de Oportunidade e Iniciativa", soma, fatorCorrecao);
    }

    private void calcularPersistencia(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 2L) + get(res, 13L) + get(res, 24L) - get(res, 35L) + get(res, 46L) + 6;
        adicionar(ls, "Persistência", soma, fatorCorrecao);
    }

    private void calcularComprometimento(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 3L) + get(res, 14L) + get(res, 25L) + get(res, 36L) - get(res, 47L) + 6;
        adicionar(ls, "Comprometimento", soma, fatorCorrecao);
    }

    private void calcularExigencia(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 4L) + get(res, 15L) + get(res, 26L) + get(res, 37L) + get(res, 48L);
        adicionar(ls, "Exigência de Qualidade e Eficiencia", soma, fatorCorrecao);
    }

    private void calcularRiscos(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 5L) + get(res, 16L) + get(res, 27L) - get(res, 38L) + get(res, 49L) + 6;
        adicionar(ls, "Correr riscos calculados", soma, fatorCorrecao);
    }

    private void calcularMetas(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 6L) - get(res, 17L) + get(res, 28L) + get(res, 39L) + get(res, 50L) + 6;
        adicionar(ls, "Estabelecimento de metas", soma, fatorCorrecao);
    }

    private void calcularBusca(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 7L) + get(res, 18L) - get(res, 29L) + get(res, 40L) + get(res, 51L) + 6;
        adicionar(ls, "Busca de Informações", soma, fatorCorrecao);
    }

    private void calcularPlanejamento(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 8L) + get(res, 19L) + get(res, 30L) - get(res, 41L) + get(res, 52L) + 6;
        adicionar(ls, "Planejamento e monitoramento", soma, fatorCorrecao);
    }

    private void calcularPersuasao(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 9L) - get(res, 20L) + get(res, 31L) + get(res, 42L) + get(res, 53L) + 6;
        adicionar(ls, "Persuasão e rede de contatos", soma, fatorCorrecao);
    }

    private void calcularIndependencia(List<ResultadoTO> ls, Resposta res, Integer fatorCorrecao) {
        Integer soma = get(res, 10L) - get(res, 21L) + get(res, 32L) + get(res, 43L) + get(res, 54L) + 6;
        adicionar(ls, "Independência e autoconfiança", soma, fatorCorrecao);
    }

    private void adicionar(List<ResultadoTO> ls, String texto, Integer soma, Integer fatorCorrecao) {
        ls.add( new ResultadoTO(texto, aplicarFatorCorrecao( soma, fatorCorrecao )) );
    }

    private Integer aplicarFatorCorrecao(Integer soma, Integer fatorCorrecao) {
        if ( fatorCorrecao == 24 || fatorCorrecao == 25 ) {
            return soma - 7;
        } else if ( fatorCorrecao == 22 || fatorCorrecao == 23 ) {
            return soma - 5;
        } else if ( fatorCorrecao == 20 || fatorCorrecao == 21 ) {
            return soma - 3;
        }
        return soma;
    }



    private Integer calcularFatorDeCorrecao(Resposta resposta) {
        return get(resposta, 11L) - get(resposta, 22L) - get(resposta, 33L) - get(resposta, 44L) + get(resposta, 55L) + 18;
    }



    private Integer get(Resposta resposta, Long id) {
        Optional<RespostaPergunta> pergunta = resposta.getLsRespostas()
                .stream()
                .filter(i -> id.equals(i.getPergunta().getId()))
                .findFirst();

        if ( pergunta.isPresent() ) {
            return pergunta.get().getPontos();
        }

        return 0;
    }





    private Float calcularFatorDeCorrecao(List<RespostaPerguntaProjection> respostas) {
        return get(respostas, 11L) - get(respostas, 22L) - get(respostas, 33L) - get(respostas, 44L) + get(respostas, 55L) + 18;
    }

    private Float get(List<RespostaPerguntaProjection> respostas, Long id) {
        Optional<RespostaPerguntaProjection> perguntaProjection = respostas.stream().filter(i -> i.getId().equals(id)).findFirst();

        if ( perguntaProjection.isPresent() ) {
            return perguntaProjection.get().getPontos();
        }

        return 0F;
    }

    private void calcularOportunidades(List<ResultadoMediaTO> ls,  List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 1L) + get(res, 12L) + get(res, 23L) - get(res, 34L) + get(res, 45L) + 6F;
        adicionar(ls, "Busca de Oportunidade e Iniciativa", soma, fatorCorrecao);
    }

    private void calcularPersistencia(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 2L) + get(res, 13L) + get(res, 24L) - get(res, 35L) + get(res, 46L) + 6;
        adicionar(ls, "Persistência", soma, fatorCorrecao);
    }

    private void calcularComprometimento(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 3L) + get(res, 14L) + get(res, 25L) + get(res, 36L) - get(res, 47L) + 6;
        adicionar(ls, "Comprometimento", soma, fatorCorrecao);
    }

    private void calcularExigencia(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 4L) + get(res, 15L) + get(res, 26L) + get(res, 37L) + get(res, 48L);
        adicionar(ls, "Exigência de Qualidade e Eficiencia", soma, fatorCorrecao);
    }

    private void calcularRiscos(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 5L) + get(res, 16L) + get(res, 27L) - get(res, 38L) + get(res, 49L) + 6;
        adicionar(ls, "Correr riscos calculados", soma, fatorCorrecao);
    }

    private void calcularMetas(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 6L) - get(res, 17L) + get(res, 28L) + get(res, 39L) + get(res, 50L) + 6;
        adicionar(ls, "Estabelecimento de metas", soma, fatorCorrecao);
    }

    private void calcularBusca(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 7L) + get(res, 18L) - get(res, 29L) + get(res, 40L) + get(res, 51L) + 6;
        adicionar(ls, "Busca de Informações", soma, fatorCorrecao);
    }

    private void calcularPlanejamento(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 8L) + get(res, 19L) + get(res, 30L) - get(res, 41L) + get(res, 52L) + 6;
        adicionar(ls, "Planejamento e monitoramento", soma, fatorCorrecao);
    }

    private void calcularPersuasao(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 9L) - get(res, 20L) + get(res, 31L) + get(res, 42L) + get(res, 53L) + 6;
        adicionar(ls, "Persuasão e rede de contatos", soma, fatorCorrecao);
    }

    private void calcularIndependencia(List<ResultadoMediaTO> ls, List<RespostaPerguntaProjection> res, Float fatorCorrecao) {
        Float soma = get(res, 10L) - get(res, 21L) + get(res, 32L) + get(res, 43L) + get(res, 54L) + 6;
        adicionar(ls, "Independência e autoconfiança", soma, fatorCorrecao);
    }

    private void adicionar(List<ResultadoMediaTO> ls, String texto, Float soma, Float fatorCorrecao) {
        ls.add( new ResultadoMediaTO(texto, aplicarFatorCorrecao( soma, fatorCorrecao )) );
    }

    private Float aplicarFatorCorrecao(Float soma, Float fatorCorrecao) {
        if ( fatorCorrecao == 24 || fatorCorrecao == 25 ) {
            return soma - 7F;
        } else if ( fatorCorrecao == 22 || fatorCorrecao == 23 ) {
            return soma - 5F;
        } else if ( fatorCorrecao == 20 || fatorCorrecao == 21 ) {
            return soma - 3F;
        }
        return soma;
    }


}
