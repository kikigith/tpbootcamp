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
import com.bootcamp.tp.exceptions.NonexistentEntityException;
import com.bootcamp.tp.models.entities.IndicateurQuantitatif;

/**
 *
 * @author kiki
 */
public class IndicateurQuantitatifController implements Serializable {

    public IndicateurQuantitatifController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndicateurQuantitatif indicateurQuantitatif) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(indicateurQuantitatif);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndicateurQuantitatif indicateurQuantitatif) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            indicateurQuantitatif = em.merge(indicateurQuantitatif);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = Integer.parseInt(indicateurQuantitatif.getId());
                if (findIndicateurQuantitatif(id) == null) {
                    throw new NonexistentEntityException("L'indicateur quantitatif d'id " + id + " n'existe plus.");
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IndicateurQuantitatif indicateurQuantitatif;
            try {
                indicateurQuantitatif = em.getReference(IndicateurQuantitatif.class, id);
                indicateurQuantitatif.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("L'indicateur quantitatif d'id " + id + " n'existe plus.", enfe);
            }
            em.remove(indicateurQuantitatif);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndicateurQuantitatif> findIndicateurQuantitatifEntities() {
        return findIndicateurQuantitatifEntities(true, -1, -1);
    }

    public List<IndicateurQuantitatif> findIndicateurQuantitatifEntities(int maxResults, int firstResult) {
        return findIndicateurQuantitatifEntities(false, maxResults, firstResult);
    }

    private List<IndicateurQuantitatif> findIndicateurQuantitatifEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndicateurQuantitatif.class));
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

    public IndicateurQuantitatif findIndicateurQuantitatif(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndicateurQuantitatif.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndicateurQuantitatifCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndicateurQuantitatif> rt = cq.from(IndicateurQuantitatif.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
