package br.com.zup.bootcamp.seguradora.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;

    public Cliente(String nome, String sobrenome, String cpf, String rg, String endereco, String email, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * @Deprecadted = uso exclusivo hibernate
     */
    @Deprecated
    public Cliente() {
    }


    public Long getId() {

        return id;
    }
}
