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
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bootcamp.tp.exceptions.NonexistentEntityException;
import com.bootcamp.tp.models.dependencies.BaseEntite;
import com.bootcamp.tp.models.entities.Beneficiaire;

/**
 *
 * @author kiki
 */
public class BeneficiaireController extends ParentController implements Serializable {
	public BeneficiaireController(EntityManager em, BaseEntite entite) {
		super(em, entite);
		// TODO Auto-generated constructor stub
	}
//    public BeneficiaireController(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//    private EntityManagerFactory emf = null;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public void create(Beneficiaire beneficiaire) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(beneficiaire);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void edit(Beneficiaire beneficiaire) throws NonexistentEntityException, Exception {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            beneficiaire = em.merge(beneficiaire);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = Integer.parseInt(beneficiaire.getId());
//                if (findBeneficiaire(id) == null) {
//                    throw new NonexistentEntityException("Le bénéficiaire d'id " + id + "n'existe plus.");
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
//        EntityManager em = emf.createEntityManager();
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Beneficiaire beneficiaire;
//            try {
//                beneficiaire = em.getReference(Beneficiaire.class, id);
//                beneficiaire.getId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Le bénéficiaire d'id " + id + " n'existe plus.", enfe);
//            }
//            em.remove(beneficiaire);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public List<Beneficiaire> findBeneficiaireByName(String nomBeneficiaire) {
//        EntityManager em = emf.createEntityManager();
//        Query qry = em.createQuery("select b from Beneficiaire b where b.nom like '" + nomBeneficiaire + "%'");
//        List<Beneficiaire> resultat = qry.getResultList();
//        return resultat;
//    }
//
//    public List<Beneficiaire> findBeneficiaireEntities() {
//        return findBeneficiaireEntities(true, -1, -1);
//    }
//
//    public List<Beneficiaire> findBeneficiaireEntities(int maxResults, int firstResult) {
//        return findBeneficiaireEntities(false, maxResults, firstResult);
//    }
//
//    private List<Beneficiaire> findBeneficiaireEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            cq.select(cq.from(Beneficiaire.class));
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
//    public Beneficiaire findBeneficiaire(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Beneficiaire.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public int getBeneficiaireCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<Beneficiaire> rt = cq.from(Beneficiaire.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }

}
