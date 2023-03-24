package com.netbiis.projetoweb.model.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "curso", schema = "formacaojava")
public class CursoEntity {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cdCurso")
    private int cdCurso;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "valor")
    private int valor;
    @Basic
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "cursoByCursoId")
    private Collection<PagamentoEntity> pagamentosByCdCurso;

    public int getCdCurso() {
        return cdCurso;
    }

    public void setCdCurso(int cdCurso) {
        this.cdCurso = cdCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CursoEntity that = (CursoEntity) o;

        if (cdCurso != that.cdCurso) return false;
        if (valor != that.valor) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cdCurso;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + valor;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public Collection<PagamentoEntity> getPagamentosByCdCurso() {
        return pagamentosByCdCurso;
    }

    public void setPagamentosByCdCurso(Collection<PagamentoEntity> pagamentosByCdCurso) {
        this.pagamentosByCdCurso = pagamentosByCdCurso;
    }
}
