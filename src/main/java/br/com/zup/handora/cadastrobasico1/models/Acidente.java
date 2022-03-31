package br.com.zup.handora.cadastrobasico1.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

@Entity
@Table(name = "acidentes")
public class Acidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Past
    private LocalDateTime dataHoraAcontecimento;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    @ManyToOne(optional = false)
    private Carro carro;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Acidente() {}

    public Acidente(@Past LocalDateTime dataHoraAcontecimento, String cidade, String estado,
                    String logradouro, String bairro, String cep, Carro carro) {
        this.dataHoraAcontecimento = dataHoraAcontecimento;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.carro = carro;
    }

    public Long getId() {
        return id;
    }

}
