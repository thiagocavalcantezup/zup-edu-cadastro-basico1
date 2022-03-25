package br.com.zup.handora.cadastrobasico1.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO {

    @NotBlank
    @Size(max = 25)
    private String nome;

    @NotBlank
    @Size(max = 25)
    private String sobrenome;

    @NotBlank
    @Size(max = 14)
    @CPF
    private String cpf;

    @NotBlank
    @Size(max = 20)
    private String rg;

    @NotBlank
    @Size(min = 30, max = 200)
    private String endereco;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    public ClienteDTO() {}

    public ClienteDTO(@NotBlank @Size(max = 25) String nome,
                      @NotBlank @Size(max = 25) String sobrenome,
                      @NotBlank @Size(max = 14) @CPF String cpf,
                      @NotBlank @Size(max = 20) String rg,
                      @NotBlank @Size(min = 30, max = 200) String endereco,
                      @NotBlank @Email String email, @NotBlank String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente paraCliente() {
        return new Cliente(nome, sobrenome, cpf, rg, endereco, email, telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
