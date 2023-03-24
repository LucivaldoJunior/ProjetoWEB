package com.netbiis.projetoweb.model.daos.implementations;


import com.netbiis.projetoweb.model.daos.IClienteDAO;
import com.netbiis.projetoweb.model.entity.ClienteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

public class ClienteDAO implements IClienteDAO {


    private static final Log log = LogFactory.getLog(ClienteDAO.class);

    private final EntityManager em;

    public ClienteDAO(EntityManager em) {
        super();
        this.em = em;
    }
    @Override
    public Optional<ClienteEntity> findByCpf(String cpf) {
        System.out.println("FindByCpf Cliente.");
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<ClienteEntity> criteriaQuery = builder.createQuery(ClienteEntity.class);
            Root<ClienteEntity> clienteRoot = criteriaQuery.from(ClienteEntity.class);
            ParameterExpression<String> cpfParameter = builder.parameter(String.class);
            criteriaQuery.where(builder.equal(clienteRoot.get("cpf"), cpfParameter));
            TypedQuery<ClienteEntity> typedQuery = em.createQuery(criteriaQuery);

            typedQuery.setParameter(cpfParameter, cpf);

            ClienteEntity cliente = typedQuery.getSingleResult();
            if (cliente == null) {
                log.debug("FindByCpf Cliente successfully! [NOT FOUND]");
                return Optional.empty();
            } else {
                log.debug("FindByCpf Cliente successfully! [FOUND]");
                return Optional.of(cliente);
            }
        } catch (Exception error) {
            log.error("FindByCpf Cliente failed!" + error.getMessage());
            return Optional.empty();

        }
    }

    @Override
    public List<ClienteEntity> findAll() {
        log.debug("FindAll Cliente");
        try {
            String query = "select c from ClienteEntity c";
            TypedQuery<ClienteEntity> typedQuery = em.createQuery(query, ClienteEntity.class);

            log.debug("FindAll Cliente success!");
            return typedQuery.getResultList();
        } catch (Exception error) {
            log.error("FindAll Cliente fail! [" + error.getMessage() + "].");
            throw error;
        }
    }

    @Override
    public void update(ClienteEntity data) {
        log.debug("Updating Cliente.");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.merge(data);
            tx.commit();

            log.debug("Updated Cliente successfully!");
        } catch (Exception error) {
            log.error("Updated Cliente failed!");
            throw error;
        }
    }

    @Override
    public void create(ClienteEntity data) {
        log.debug("Persisting Cliente.");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(data);
            em.detach(data);
            tx.commit();

            log.debug("Persisted Cliente successfully!");
        } catch (Exception error) {
            log.error("Persisted Cliente failed!");
            throw error;
        }
    }

    @Override
    public void delete(ClienteEntity data) {
        log.debug("Deleted Cliente.");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.remove(data);
            tx.commit();

            log.debug("Deleted Cliente successfully!");
        } catch (Exception error) {
            log.error("Deleted Cliente failed!");
            throw error;
        }
    }
}
