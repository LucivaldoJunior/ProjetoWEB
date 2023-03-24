package com.netbiis.projetoweb.model.daos.implementations;

import com.netbiis.projetoweb.model.daos.ICursoDAO;
import com.netbiis.projetoweb.model.entity.CursoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

public class CursoDAO implements ICursoDAO {
    private static final Log log = LogFactory.getLog(CursoDAO.class);

    private final EntityManager em;

    public CursoDAO(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public Optional<CursoEntity> find(int cdCurso) {

        System.out.println("Find Curso.");
        try {
            TypedQuery<CursoEntity> typedQuery = em.createQuery("SELECT c FROM CursoEntity c WHERE c.cdCurso=:cdCurso", CursoEntity.class);
            typedQuery.setParameter("cdCurso", cdCurso);
           CursoEntity curso = typedQuery.getSingleResult();
            if (curso == null) {
                log.debug("Find Curso successfully! [NOT FOUND]");
                return Optional.empty();
            } else {
                log.debug("Find Curso successfully! [FOUND]");
                return Optional.of(curso);
            }
        } catch (Exception error) {
            log.error("Find Curso failed!" + error.getMessage());
            return Optional.empty();

        }

    }

    @Override
    public List<CursoEntity> findAll() {
        log.debug("FindAll Cursos");
        try {
            String query = "select c from CursoEntity c";
            TypedQuery<CursoEntity> typedQuery = em.createQuery(query, CursoEntity.class);

            log.debug("FindAll Cursos success!");
            return typedQuery.getResultList();
        } catch (Exception error) {
            log.error("FindAll Cursos fail! [" + error.getMessage() + "].");
            throw error;
        }
    }

    @Override
    public void create(CursoEntity curso) {
        log.debug("Persisting Curso.");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(curso);

            tx.commit();

            log.debug("Persisted Curso successfully!");
        } catch (Exception error) {
            log.error("Persisted Curso failed!");
            throw error;
        }
    }

    @Override
    public void update(CursoEntity curso) {
        log.debug("Updating Curso.");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.merge(curso);
            tx.commit();

            log.debug("Updated Curso successfully!");
        } catch (Exception error) {
            log.error("Updated Curso failed!");
            throw error;
        }
    }

    @Override
    public void delete(CursoEntity curso) {
        log.debug("Deleted Curso.");
        try {
            EntityTransaction tx = em.getTransaction();
            CursoEntity cursoapagar = em.find(CursoEntity.class,curso.getCdCurso());
            tx.begin();
            em.remove(cursoapagar);
            tx.commit();

            log.debug("Deleted Curso successfully!");
        } catch (Exception error) {
            log.error("Deleted Curso failed!");
            throw error;
        }
    }
}
