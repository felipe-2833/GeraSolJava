package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class UsuariosTO {
    private Long idUsuario;
    @NotBlank private String nomeCompleto;
    @NotBlank private String email;
    @NotBlank private String senha;
    @NotBlank private String telefone;
    @Past private LocalDate dataNascimento;

    public UsuariosTO() {
    }

    public UsuariosTO(Long idUsuario, String nomeCompleto, String email, String senha, String telefone, LocalDate dataNascimento) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
