package br.edu.materdei.backend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESPOSTA")
@Getter
@Setter
public class Resposta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
     @OneToMany(mappedBy = "resposta", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true, 
            fetch = FetchType.LAZY)
    private List<RespostaPergunta> lsRespostas;
    
}
