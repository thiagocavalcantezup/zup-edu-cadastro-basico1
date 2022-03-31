package br.com.zup.handora.cadastrobasico1.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CarroDTO {

    @NotBlank
    private String placa;

    @NotBlank
    @Size(min = 11, max = 11)
    private String renavam;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String chassi;

    @NotNull
    @Positive
    private Integer ano;

    @NotNull
    @Positive
    private BigDecimal valor;

    public CarroDTO() {}

    public CarroDTO(@NotBlank String placa, @NotBlank @Size(min = 11, max = 11) String renavam,
                    @NotBlank String marca, @NotBlank String modelo, @NotBlank String chassi,
                    @NotNull @Positive Integer ano, @NotNull @Positive BigDecimal valor) {
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.ano = ano;
        this.valor = valor;
    }

    public Carro paraCarro(Cliente cliente) {
        return new Carro(placa, renavam, marca, modelo, chassi, ano, valor, cliente);
    }

    public String getPlaca() {
        return placa;
    }

    public String getrenavam() {
        return renavam;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
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

}
