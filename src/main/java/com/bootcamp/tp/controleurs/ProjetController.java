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
import com.bootcamp.tp.models.dependencies.BaseEntite;
import com.bootcamp.tp.models.entities.Fournisseur;
import com.bootcamp.tp.models.entities.IndicateurPerformance;
import com.bootcamp.tp.models.entities.Projet;

/**
 *
 * @author kiki
 */
public class ProjetController extends ParentController implements Serializable {

	public ProjetController(EntityManager em, BaseEntite entite) {
		super(em, entite);
		// TODO Auto-generated constructor stub
	}

	
//    public ProjetController(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//    private EntityManagerFactory emf = null;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public void create(Projet projet) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(projet);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void edit(Projet projet) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            projet = em.merge(projet);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = Integer.parseInt(projet.getId());
//                if (findProjet(id) == null) {
//                    throw new NonexistentEntityException("Le projet d'id " + id + " n'existe plus.");
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
//            Projet projet;
//            try {
//                projet = em.getReference(Projet.class, id);
//                projet.getId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Le projet d'id " + id + " n'existe plus.", enfe);
//            }
//            em.remove(projet);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//    
//    public void addFournisseurs(List<Fournisseur> frs, Integer id){
//        EntityManager em = emf.createEntityManager();
//          try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Projet projet;
//              try {
//                  projet=em.getReference(Projet.class, id);
////                  projet.setFournisseurs(frs);
//              em.merge(projet);
//              } catch (Exception e) {
//              }
//              em.getTransaction().commit();
//        } catch (Exception e) {
//        }
//        
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
//    public List<Projet> findProjetByName(String nomProjet) {
//        EntityManager em = emf.createEntityManager();
//        Query qry = em.createQuery("select p from Projet p where p.nom like '" + nomProjet + "%'");
//        List<Projet> resultat = qry.getResultList();
//        return resultat;
//    }
//
//    public List<Projet> findProjetEntities() {
//        return findProjetEntities(true, -1, -1);
//    }
//
//    public List<Projet> findProjetEntities(int maxResults, int firstResult) {
//        return findProjetEntities(false, maxResults, firstResult);
//    }
//
//    private List<Projet> findProjetEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            cq.select(cq.from(Projet.class));
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
//    public Projet findProjet(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Projet.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public IndicateurPerformance findIndicateur(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(IndicateurPerformance.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public int getProjetCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<Projet> rt = cq.from(Projet.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }

}
