package br.com.zup.bootcamp.seguradora.controller;

import br.com.zup.bootcamp.seguradora.model.Acidente;
import br.com.zup.bootcamp.seguradora.model.Carro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AcidenteRequest {

    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String bairro;
    private String cep;
    @NotBlank
    private String observacoes;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime ocorridoEm;

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public LocalDateTime getOcorridoEm() {
        return ocorridoEm;
    }

    public Acidente toModel(Carro carro) {

        return new Acidente(cidade,estado,logradouro,bairro,cep, observacoes, ocorridoEm, carro);
    }
}
