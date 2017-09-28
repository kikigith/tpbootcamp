/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp.controleurs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.bootcamp.tp.controleurs.exceptions.NonexistentEntityException;
import com.bootcamp.tp.models.entities.IndicateurPerformance;

/**
 *
 * @author kiki
 */
public class IndicateurPerformanceController implements Serializable {

    public IndicateurPerformanceController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndicateurPerformance indicateurPerformance) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(indicateurPerformance);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndicateurPerformance indicateurPerformance) throws NonexistentEntityException, Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            indicateurPerformance = em.merge(indicateurPerformance);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = Integer.parseInt(indicateurPerformance.getId());
                if (findIndicateurPerformance(id) == null) {
                    throw new NonexistentEntityException("L'indicateur d'id " + id + " n'existe plus.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = emf.createEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IndicateurPerformance indicateurPerformance;
            try {
                indicateurPerformance = em.getReference(IndicateurPerformance.class, id);
                indicateurPerformance.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("L'indicateur d'id " + id + " n'existe plus.", enfe);
            }
            em.remove(indicateurPerformance);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndicateurPerformance> findIndicateurPerformanceByLibelle(String libelleIndicateur) {
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("select i from InidcateurPerformance i where i.nom like '" + libelleIndicateur + "%'");
        List<IndicateurPerformance> resultat = qry.getResultList();
        return resultat;
    }

    public List<IndicateurPerformance> findIndicateurPerformanceEntities() {
        return findIndicateurPerformanceEntities(true, -1, -1);
    }

    public List<IndicateurPerformance> findIndicateurPerformanceEntities(int maxResults, int firstResult) {
        return findIndicateurPerformanceEntities(false, maxResults, firstResult);
    }

    private List<IndicateurPerformance> findIndicateurPerformanceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndicateurPerformance.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public IndicateurPerformance findIndicateurPerformance(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndicateurPerformance.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndicateurPerformanceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndicateurPerformance> rt = cq.from(IndicateurPerformance.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
