package com.bootcamp.tp.controleurs;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.json.JSONObject;

import com.bootcamp.tp.models.dependencies.BaseEntite;

public  abstract class ParentController<T extends BaseEntite> implements Serializable{

	private EntityManager em;
	private T entite;




	public ParentController(EntityManager em, T entite) {
		super();
		this.em = em;
		this.entite = entite;
	}


	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	public T getEntite() {
		return entite;
	}


	public void setEntite(T entite) {
		this.entite = entite;
	}


	/**
	 * Convert a class name with FQDN format into an object instance
	 * 
	 * @param className the name of the class to be instanciated
	 * @return obj an object of className class; obj is null if it's
	 * not an instance of BaseEntite
	 * @throws ClassNotFoundException
	 * @throws InstanciationException
	 * @throws IllegalAccessException
	 */
	protected Object fromName2Instance(String className) throws 
	ClassNotFoundException, InstantiationException, IllegalAccessException{
		String classFQDN = className;
		//if non fqdn class name provided, then convert into fqdn class name
		if(!className.contains(".")) {
			classFQDN = "com.bootcamp.tp.models.entities."+className;
		}
		Class cls=Class.forName(classFQDN);
		Object obj=cls.newInstance();
		if(!(obj instanceof BaseEntite)){

			return null;}
		return obj;
	}

	/**
	 * Persist any objet of any Entity class derived from BaseEntite
	 * 
	 * @param entite
	 * @throws DuplicateKeyException
	 */
	public String saveRecord(T entite){
		if(entite != null){
			em.getTransaction().begin();
			em.persist(entite);
			em.flush();
			em.getTransaction().commit();
			return entite.getId();
		}
		return null;
	}

	/**
	 * Persist any objet of any Entity class derived from BaseEntite
	 * 
	 * @param entite
	 * @return T
	 * @throws EntityNotFoundException
	 */
	public T updateRecord(T entite){
		BaseEntite be = em.find(entite.getClass(), entite.getId());
		if(be != null){
			em.getTransaction().begin();
			em.merge(entite);
			em.getTransaction().commit();
			return entite;
		}
		return null;
	}

	/**
	 * Delete any objet of any Entity class derived from BaseEntite
	 * 
	 * @param entite
	 * @throws EntityNotFoundException
	 */
	public void delete(T entite) {
		if(!(em.contains(entite))){
			BaseEntite be= em.find(entite.getClass(), entite.getId());
			if(be!=null){
				em.getTransaction().begin();
				em.remove(em.merge(entite));
				em.flush();
				em.getTransaction().commit();
			}
		}

	}


	/**
	 * findByProperty : method used to search for an instance of entity class
	 *     using one of the given entity's field and providing a value for the 
	 *     selected field 
	 * @param propertyName
	 * @param propertyValue
	 * @return an instance of BaseEntite
	 */

	public <T extends BaseEntite> T findByProperty(String propertyName, Object propertyValue){

		String className=entite.getClass().getSimpleName();
		String query = "SELECT i FROM "+
				className + " i WHERE i."+propertyName+"= :param";
		Query q=getEm().createQuery(query);
		//		if(propertyName == "id"){
		//
		//			q.setParameter("param", Integer.parseInt(propertyValue.toString()));
		//		}else{
		q.setParameter("param", propertyValue.toString());

		//		}


		return (T)q.getSingleResult();
	}

	/**
	 * findAll : used to retrieve all instances of an entity class
	 * @return
	 */
	public <T extends BaseEntite> List<T> findAll(){
		List<T> result=new ArrayList<T>();
		String className=entite.getClass().getSimpleName();
		String query = "SELECT i FROM "+ className + " i";
		Query q=getEm().createQuery(query);
		result=q.getResultList();

		return result;
	}

	/**
	 * printAllAsJson: displays all instances of a given 
	 *    entity in Json format:
	 */
	public void printAllAsJson(){
		List<T> allInstances=findAll();
		for(T i:allInstances){
			JsonObject jo=getAsJSON(i);
			System.out.println("Objet "+i.getClass().getSimpleName()+" "+ i.getId()+" converti en JSON \n"+jo);
		}
	}
	/**
	 * getCount : count rows number of a given entity class
	 * @return rows number
	 */
	public int getCount(){
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			//            String className=entite.getClass().getSimpleName();
			Root<T> rt = cq.from(entite.getClass());
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}

	}

	/**
	 * findEntitiesInRange: search all entities of an entity class
	 *    return a list of instances in [firstResult, maxResults] range
	 *    when all is set to false. Else return all instances paginated
	 *    with the range
	 * @param all
	 * @param maxResults
	 * @param firstResult
	 * @return
	 */
	public List<T> findEntitiesInRange(boolean all, int maxResults, int firstResult) {
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();

			cq.select(cq.from(entite.getClass()));
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

	/**
	 * getAsJSON: convert an entity into Json object
	 * @param obj
	 * @return
	 */
	private JsonObject getAsJSON(final T obj){
		JsonObjectBuilder entityBuilder=Json.createObjectBuilder();
		JsonObject entityJson;


		Field[] valueObjFields =obj.getClass().getDeclaredFields();
		for(int i=0; i<valueObjFields.length; i++){

			String fieldName=valueObjFields[i].getName();
			valueObjFields[i].setAccessible(true);
			try {
				Object newObj=valueObjFields[i].get(obj);
//				System.out.println("valeur "+newObj);
				if(newObj!=null){
					entityBuilder.add(fieldName, newObj.toString());
					}

				//				return entityJson;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		entityJson=entityBuilder.build();
		return entityJson;
	}


}
