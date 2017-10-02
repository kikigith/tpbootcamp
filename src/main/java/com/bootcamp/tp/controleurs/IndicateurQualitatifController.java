/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp.controleurs;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.bootcamp.tp.models.dependencies.BaseEntite;

/**
 *
 * @author kiki
 */
public class IndicateurQualitatifController extends ParentController implements Serializable {

	public IndicateurQualitatifController(EntityManager em, BaseEntite entite) {
		super(em, entite);
		// TODO Auto-generated constructor stub
	}

	
//    public IndicateurQualitatifController(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//    private EntityManagerFactory emf = null;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public void create(IndicateurQualitatif indicateurQualitatif) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(indicateurQualitatif);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void edit(IndicateurQualitatif indicateurQualitatif) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            indicateurQualitatif = em.merge(indicateurQualitatif);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = Integer.parseInt(indicateurQualitatif.getId());
//                if (findIndicateurQualitatif(id) == null) {
//                    throw new NonexistentEntityException("L'indicateur qualitatif d'id " + id + " n'existe plus.");
//                }
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            IndicateurQualitatif indicateurQualitatif;
//            try {
//                indicateurQualitatif = em.getReference(IndicateurQualitatif.class, id);
//                indicateurQualitatif.getId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("L'indicateur qualitatif d'id " + id + " n'existe plus.", enfe);
//            }
//            em.remove(indicateurQualitatif);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public List<IndicateurQualitatif> findIndicateurQualitatifEntities() {
//        return findIndicateurQualitatifEntities(true, -1, -1);
//    }
//
//    public List<IndicateurQualitatif> findIndicateurQualitatifEntities(int maxResults, int firstResult) {
//        return findIndicateurQualitatifEntities(false, maxResults, firstResult);
//    }
//
//    private List<IndicateurQualitatif> findIndicateurQualitatifEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            cq.select(cq.from(IndicateurQualitatif.class));
//            Query q = em.createQuery(cq);
//            if (!all) {
//                q.setMaxResults(maxResults);
//                q.setFirstResult(firstResult);
//            }
//            return q.getResultList();
//        } finally {
//            em.close();
//        }
//    }
//
//    public IndicateurQualitatif findIndicateurQualitatif(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(IndicateurQualitatif.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public int getIndicateurQualitatifCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<IndicateurQualitatif> rt = cq.from(IndicateurQualitatif.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }
    
}
