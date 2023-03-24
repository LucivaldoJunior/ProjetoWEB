package com.netbiis.projetoweb;

import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import jakarta.persistence.*;

public class ClienteApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPANovo");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        int idcliente = 6;
        int idCurso = 3;
        TypedQuery<PagamentoEntity> typedQuery = em.createQuery("SELECT c FROM PagamentoEntity c WHERE c.clienteByClienteId.idCliente=:idc and c.cursoByCursoId.cdCurso=:idCu", PagamentoEntity.class);
        typedQuery.setParameter("idc", idcliente).setParameter("idCu", idCurso);
        PagamentoEntity pagamentodeltado = typedQuery.getSingleResult();
        System.out.println(pagamentodeltado.getClienteByClienteId().getNome());
         //em.detach(curso);

      //  TypedQuery<CursoEntity> cursoq = em.createQuery("select c from CursoEntity c", CursoEntity.class);
      //  List<CursoEntity> cursos = cursoq.getResultList();
       // cursos.forEach(c -> System.out.println(c.getNome()));
        //Cliente cliente = em.find(Cliente.class,34567921);
        //cliente.setEmail("thyagoronald@gmail.com");
      //TypedQuery<ClienteEntity> clienteQuery = em.createQuery("select c from ClienteEntity c", ClienteEntity.class);
      //List<ClienteEntity> clientes = clienteQuery.getResultList();
       // clientes.forEach(cliente -> System.out.println(cliente.getNome()));

        // Cliente antonio = new Cliente("570.618.272","Thyago Ronald", "thyagoronald@gmail.com");
        //em.persist(antonio);
        //em.delete(antonio);
        //em.merge(cliente);

        tx.commit();

    }
}
