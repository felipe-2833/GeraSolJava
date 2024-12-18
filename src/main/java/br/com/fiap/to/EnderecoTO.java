package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class EnderecoTO {
    private Long idEndereco;
    private Long enderecoIdUser;
    @NotBlank private String cep;
    @NotBlank private String rua;
    @NotBlank private String cidade;
    @NotBlank private String estado;
    @NotNull @PositiveOrZero private int numero;

    public EnderecoTO() {
    }

    public EnderecoTO(Long idEndereco, Long enderecoIdUser, String cep, String rua, String cidade, String estado, int numero) {
        this.idEndereco = idEndereco;
        this.enderecoIdUser = enderecoIdUser;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Long getEnderecoIdUser() {
        return enderecoIdUser;
    }

    public void setEnderecoIdUser(Long enderecoIdUser) {
        this.enderecoIdUser = enderecoIdUser;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
