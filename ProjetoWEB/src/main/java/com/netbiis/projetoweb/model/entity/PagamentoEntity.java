package com.netbiis.projetoweb.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "pagamento", schema = "formacaojava")
public class PagamentoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpagamento")
    private int idpagamento;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente", nullable = false)
    private ClienteEntity clienteByClienteId;
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "cdCurso", nullable = false)
    private CursoEntity cursoByCursoId;

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }



    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagamentoEntity that = (PagamentoEntity) o;

        if (idpagamento != that.idpagamento) return false;

        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpagamento;

        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    public ClienteEntity getClienteByClienteId() {
        return clienteByClienteId;
    }

    public void setClienteByClienteId(ClienteEntity clienteByClienteId) {
        this.clienteByClienteId = clienteByClienteId;
    }

    public CursoEntity getCursoByCursoId() {
        return cursoByCursoId;
    }

    public void setCursoByCursoId(CursoEntity cursoByCursoId) {
        this.cursoByCursoId = cursoByCursoId;
    }
}
