package com.netbiis.projetoweb.model.daos.implementations;

import com.netbiis.projetoweb.model.daos.IpagamentoDAO;
import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

public class PagamentoDAO implements IpagamentoDAO {

    private static final Log log = LogFactory.getLog(PagamentoDAO.class);
    private final EntityManager em;

    public PagamentoDAO(EntityManager em) {
        super();
        this.em = em;
    }


    @Override
    public Optional<PagamentoEntity> find(PagamentoEntity pagamento) {
       try {


           int idcliente = pagamento.getClienteByClienteId().getIdCliente();
           int idCurso = pagamento.getCursoByCursoId().getCdCurso();
           TypedQuery<PagamentoEntity> typedQuery = em.createQuery("SELECT c FROM PagamentoEntity c WHERE c.clienteByClienteId.idCliente=:idc and c.cursoByCursoId.cdCurso=:idCu", PagamentoEntity.class);
           typedQuery.setParameter("idc", idcliente).setParameter("idCu", idCurso);
           PagamentoEntity pagamentodeltado = typedQuery.getSingleResult();
           if (pagamentodeltado == null) {
               log.debug("Find Pagamento successfully! [NOT FOUND]");
               return Optional.empty();
           } else {
               log.debug("Find Pagamento successfully! [FOUND]");
               return Optional.of(pagamentodeltado);
           }
       }catch (Exception error) {
           log.error("Find Pagamento failed!" + error.getMessage());
           return Optional.empty();
    }
    }

    @Override
    public List<PagamentoEntity> findAll() {
        log.debug("Find All Pagamentos");
        try {
            String query = "select c from PagamentoEntity c";
            TypedQuery<PagamentoEntity> typedQuery = em.createQuery(query, PagamentoEntity.class);

            log.debug("Find All Pagamentos success!");
            return typedQuery.getResultList();
        } catch (Exception error) {
            log.error("Find All Pagamentos fail! [" + error.getMessage() + "].");
            throw error;
        }
    }

    @Override
    public void create(PagamentoEntity pagamento) {
        log.debug("Persisting Pagamento.");
        try {
            EntityTransaction tx = em.getTransaction();


            tx.begin();

            em.persist(pagamento);
           // em.detach(pagamento);
            tx.commit();

            log.debug("Persisted Pagamento successfully!");
        } catch (Exception error) {
            log.error("Persisted Pagamento failed!");
            throw error;
        }
    }

    @Override
    public void update(PagamentoEntity pagamento) {
        log.debug("Updating Pagamento.");
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(pagamento);
            tx.commit();

            log.debug("Updating Pagamento successfully!");
        } catch (Exception error) {
            log.error("Updating Pagamento failed!");
            throw error;
        }
    }

    @Override
    public void delete(PagamentoEntity pagamento) {
        log.debug("Deleted Pagamento.");
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(pagamento);
            tx.commit();

            log.debug("Deleted Pagamento successfully!");
        } catch (Exception error) {
            log.error("Deleted Pagamento failed!");
            throw error;
        }
    }
}
