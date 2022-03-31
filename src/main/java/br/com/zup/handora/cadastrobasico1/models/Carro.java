package br.com.zup.handora.cadastrobasico1.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false, length = 11)
    private String renavam;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String chassi;

    @Column(nullable = false)
    @Positive
    private Integer ano;

    @Column(nullable = false)
    @Positive
    private BigDecimal valor;

    @ManyToOne(optional = false)
    Cliente cliente;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Carro() {}

    public Carro(String placa, String renavam, String marca, String modelo, String chassi,
                 Integer ano, BigDecimal valor, Cliente cliente) {
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.ano = ano;
        this.valor = valor;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

}
