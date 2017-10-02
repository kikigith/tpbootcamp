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
public class FournisseurController extends ParentController implements Serializable {

	public FournisseurController(EntityManager em, BaseEntite entite) {
		super(em, entite);
		// TODO Auto-generated constructor stub
	}

//    public FournisseurController(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//    private EntityManagerFactory emf = null;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public void create(Fournisseur fournisseur) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(fournisseur);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void edit(Fournisseur fournisseur) throws NonexistentEntityException, Exception {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            fournisseur = em.merge(fournisseur);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = Integer.parseInt(fournisseur.getId());
//                if (findFournisseur(id) == null) {
//                    throw new NonexistentEntityException("Le fournisseur d'id " + id + " n'existe plus.");
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
//    public List<Fournisseur> findFournisseurByName(String nomFournisseur) {
//        EntityManager em = emf.createEntityManager();
//        Query qry = em.createQuery("select f from Fournisseur f where f.nom like '" + nomFournisseur + "%'");
//        List<Fournisseur> resultat = qry.getResultList();
//        return resultat;
//    }
//
//    public void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Fournisseur fournisseur;
//            try {
//                fournisseur = em.getReference(Fournisseur.class, id);
//                fournisseur.getId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Le fournisseur d'id " + id + " n'existe plus", enfe);
//            }
//            em.remove(fournisseur);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public List<Fournisseur> findFournisseurEntities() {
//        return findFournisseurEntities(true, -1, -1);
//    }
//
//    public List<Fournisseur> findFournisseurEntities(int maxResults, int firstResult) {
//        return findFournisseurEntities(false, maxResults, firstResult);
//    }
//
//    private List<Fournisseur> findFournisseurEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            cq.select(cq.from(Fournisseur.class));
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
//    public Fournisseur findFournisseur(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Fournisseur.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public int getFournisseurCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<Fournisseur> rt = cq.from(Fournisseur.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }

}
