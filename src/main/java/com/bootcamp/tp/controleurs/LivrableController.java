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
import com.bootcamp.tp.models.entities.Livrable;

/**
 *
 * @author kiki
 */
public class LivrableController implements Serializable {

    public LivrableController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Livrable livrable) {
        EntityManager em = emf.createEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(livrable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Livrable livrable) throws NonexistentEntityException, Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            livrable = em.merge(livrable);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = Integer.parseInt(livrable.getId());
                if (findLivrable(id) == null) {
                    throw new NonexistentEntityException("Le livrable d'id " + id + " n'existe plus.");
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
            Livrable livrable;
            try {
                livrable = em.getReference(Livrable.class, id);
                livrable.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Le livrable d'id " + id + " n'existe plus.", enfe);
            }
            em.remove(livrable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Livrable> findLivrableByName(String nomLivrable) {
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("select b from Livrable b where b.nom like '" + nomLivrable + "%'");
        List<Livrable> resultat = qry.getResultList();
        return resultat;
    }
    public List<Livrable> findLivrableEntities() {
        return findLivrableEntities(true, -1, -1);
    }

    public List<Livrable> findLivrableEntities(int maxResults, int firstResult) {
        return findLivrableEntities(false, maxResults, firstResult);
    }

    private List<Livrable> findLivrableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Livrable.class));
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

    public Livrable findLivrable(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Livrable.class, id);
        } finally {
            em.close();
        }
    }

    public int getLivrableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Livrable> rt = cq.from(Livrable.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
