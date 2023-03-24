package com.netbiis.projetoweb.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "login", schema = "formacaojava")
public class LoginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cpf")
    private String cpf;
    @Basic
    @Column(name = "senha")
    private String senha;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEntity that = (LoginEntity) o;

        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cpf != null ? cpf.hashCode() : 0;
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }
}
