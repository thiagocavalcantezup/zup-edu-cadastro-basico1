package br.com.zup.handora.cadastrobasico1.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AcidenteDTO {

    @NotNull
    @PastOrPresent
    @JsonProperty("data_hora_acontecimento")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHoraAcontecimento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cep;

    public AcidenteDTO() {}

    public AcidenteDTO(@NotNull @Past LocalDateTime dataHoraAcontecimento, @NotBlank String cidade,
                       @NotBlank String estado, @NotBlank String logradouro,
                       @NotBlank String bairro, @NotBlank String cep) {
        this.dataHoraAcontecimento = dataHoraAcontecimento;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Acidente paraAcidente(Carro carro) {
        return new Acidente(dataHoraAcontecimento, cidade, estado, logradouro, bairro, cep, carro);
    }

    public LocalDateTime getDataHoraAcontecimento() {
        return dataHoraAcontecimento;
    }

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

}
