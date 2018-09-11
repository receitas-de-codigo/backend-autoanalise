package br.edu.materdei.backend.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESPOSTA_PERGUNTA")
@Getter
@Setter
public class RespostaPergunta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn
    private Pergunta pergunta;
    
    @ManyToOne
    @JoinColumn
    private Resposta resposta;
    
    private Integer pontos;
    
}
