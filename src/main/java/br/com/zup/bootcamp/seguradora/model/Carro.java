package br.com.zup.bootcamp.seguradora.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false,length = 11)
    private String renavam;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false,length = 17)
    private String chassi;
    @Column(nullable = false)
    private  Integer ano;
    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(optional = false)
    private Cliente cliente;

    public Carro(String placa, String renavam, String marca, String chassi, Integer ano, BigDecimal valor,Cliente cliente) {
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.chassi = chassi;
        this.ano = ano;
        this.valor = valor;
        this.cliente = cliente;
    }

    /**
     * @Deprecated = uso exclusivo do hibernate
     */
    @Deprecated
    public Carro() {
    }

    public Long getId() {

        return id;
    }
}
