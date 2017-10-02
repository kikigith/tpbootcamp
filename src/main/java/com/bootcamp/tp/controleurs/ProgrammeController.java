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
import com.bootcamp.tp.models.entities.IndicateurPerformance;
import com.bootcamp.tp.models.entities.Programme;

/**
 *
 * @author kiki
 */
public class ProgrammeController extends ParentController implements Serializable {

	public ProgrammeController(EntityManager em, BaseEntite entite) {
		super(em, entite);
		// TODO Auto-generated constructor stub
	}

	
//    public ProgrammeController(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//    private EntityManagerFactory emf = null;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public void create(Programme programme) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(programme);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void edit(Programme programme) throws NonexistentEntityException, Exception {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            programme = em.merge(programme);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = Integer.parseInt(programme.getId());
//                if (findProgramme(id) == null) {
//                    throw new NonexistentEntityException("The programme with id " + id + " no longer exists.");
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
//            Programme programme;
//            try {
//                programme = em.getReference(Programme.class, id);
//                programme.getId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The programme with id " + id + " no longer exists.", enfe);
//            }
//            em.remove(programme);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
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
//    public List<Programme> findProgrammeByName(String nomProgramme) {
//        EntityManager em = emf.createEntityManager();
//        Query qry = em.createQuery("select p from Programme p where p.nom like '" + nomProgramme + "%'");
//        List<Programme> resultat = qry.getResultList();
//        return resultat;
//    }
//
//    public List<Programme> findProgrammeEntities() {
//        return findProgrammeEntities(true, -1, -1);
//    }
//
//    public List<Programme> findProgrammeEntities(int maxResults, int firstResult) {
//        return findProgrammeEntities(false, maxResults, firstResult);
//    }
//
//    private List<Programme> findProgrammeEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            cq.select(cq.from(Programme.class));
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
//    public Programme findProgramme(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Programme.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public int getProgrammeCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<Programme> rt = cq.from(Programme.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }

}
