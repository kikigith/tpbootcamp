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
import com.bootcamp.tp.models.entities.Bailleur;

/**
 *
 * @author kiki
 */
public class BailleurController implements Serializable {

    public BailleurController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }	

    public void create(Bailleur bailleur) {
        EntityManager em = emf.createEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bailleur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bailleur bailleur) throws NonexistentEntityException, Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bailleur = em.merge(bailleur);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = Integer.parseInt(bailleur.getId());
                if (findBailleur(id) == null) {
                    throw new NonexistentEntityException("The bailleur with id " + id + " no longer exists.");
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
            Bailleur bailleur;
            try {
                bailleur = em.getReference(Bailleur.class, id);
                bailleur.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bailleur with id " + id + " no longer exists.", enfe);
            }
            em.remove(bailleur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bailleur> findBailleurByName(String nomBailleur) {
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("select b from Bailleur b where b.nom like '" + nomBailleur + "%'");
        List<Bailleur> resultat = qry.getResultList();
        return resultat;
    }

    public List<Bailleur> findBailleurEntities() {
        return findBailleurEntities(true, -1, -1);
    }

    public List<Bailleur> findBailleurEntities(int maxResults, int firstResult) {
        return findBailleurEntities(false, maxResults, firstResult);
    }

    private List<Bailleur> findBailleurEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bailleur.class));
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

    public Bailleur findBailleur(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bailleur.class, id);
        } finally {
            em.close();
        }
    }

    public int getBailleurCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bailleur> rt = cq.from(Bailleur.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
