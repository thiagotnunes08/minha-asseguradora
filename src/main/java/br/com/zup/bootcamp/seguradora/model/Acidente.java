package br.com.zup.bootcamp.seguradora.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Acidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String bairro;
    private String cep;
    @Column(nullable = false)
    private String obeservacoes;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime ocorridoEm;

    @ManyToOne(optional = false)
    private Carro carro;

    public Acidente(String cidade, String estado, String logradouro, String bairro, String cep, String obeservacoes, LocalDateTime ocorridoEm,Carro carro) {
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.obeservacoes = obeservacoes;
        this.carro = carro;
        this.ocorridoEm = ocorridoEm;
    }

    /**
     * @Deprecated = construtor do hibernate
     */
    @Deprecated
    public Acidente() {
    }

    public Long getId() {
        return id;
    }
}
