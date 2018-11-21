package br.edu.materdei.backend.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERGUNTA")
@Getter
@Setter
public class Pergunta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String pergunta;

    private Integer ativo;

    private transient Integer pontos;

}
