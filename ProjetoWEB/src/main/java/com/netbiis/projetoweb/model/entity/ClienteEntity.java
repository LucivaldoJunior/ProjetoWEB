package com.netbiis.projetoweb.model.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "cliente", schema = "formacaojava")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCliente")
    private int idCliente;
    @Basic
    @Column(name = "cpf")
    private String cpf;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "clienteByClienteId")
    private Collection<PagamentoEntity> pagamentosByIdCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (idCliente != that.idCliente) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<PagamentoEntity> getPagamentosByIdCliente() {
        return pagamentosByIdCliente;
    }

    public void setPagamentosByIdCliente(Collection<PagamentoEntity> pagamentosByIdCliente) {
        this.pagamentosByIdCliente = pagamentosByIdCliente;
    }
}
