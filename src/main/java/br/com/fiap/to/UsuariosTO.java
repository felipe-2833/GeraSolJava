package br.com.fiap.to;

import java.time.LocalDate;

public class UsuariosTO {
    private Long isUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;
    private String telefone;
    private LocalDate dataNascimento;

    public UsuariosTO() {
    }

    public UsuariosTO(Long isUsuario, String nomeUsuario, String email, String senha, String telefone, LocalDate dataNascimento) {
        this.isUsuario = isUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Long getIsUsuario() {
        return isUsuario;
    }

    public void setIsUsuario(Long isUsuario) {
        this.isUsuario = isUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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
