package br.com.zup.bootcamp.seguradora.dto;

import br.com.zup.bootcamp.seguradora.model.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    private String rg;
    @NotBlank
    private String endereco;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }


    public Cliente toModel() {
        return new Cliente(nome,sobrenome,cpf,rg,endereco,email,telefone);
    }
}
