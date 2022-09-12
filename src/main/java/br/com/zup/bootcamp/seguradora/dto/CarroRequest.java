package br.com.zup.bootcamp.seguradora.dto;

import br.com.zup.bootcamp.seguradora.model.Carro;
import br.com.zup.bootcamp.seguradora.model.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Optional;

public class CarroRequest {
    @NotBlank
    private String placa;
    @NotBlank
    @Length(min = 11,max = 11)
    private String renavam;
    @NotBlank
    private String marca;
    @NotBlank
    @Length(min = 17,max = 17)
    private String chassi;
    @NotNull

    private  Integer ano;
    @NotNull
    private BigDecimal valor;

    public String getPlaca() {
        return placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public String getMarca() {
        return marca;
    }

    public String getChassi() {
        return chassi;
    }

    public Integer getAno() {
        return ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Carro toCarro(Cliente cliente) {

        return new Carro(placa,renavam,marca,chassi,ano,valor,cliente);
    }
}
