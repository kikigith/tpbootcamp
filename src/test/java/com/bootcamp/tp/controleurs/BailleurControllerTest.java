package com.bootcamp.tp.controleurs;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.bootcamp.tp.models.entities.Bailleur;


public class BailleurControllerTest {
//	private Bailleur bailleur;//Initialise les données en entrée de saveRecord, updateRecord et delete 
//	private Bailleur bEnregistre, bModifie, bSupprime;//Instance enregistrée, modifiée ou supprimée
//	private BailleurController bc;
	private EntityManagerFactory emf;
	private EntityManager em;
	private BailleurController bc;
	private Bailleur b;
	
	@Before
	public void init() throws SQLException{
		emf=Persistence.createEntityManagerFactory("tpmsqlPU");
		em=emf.createEntityManager();
		b=new Bailleur();
		bc=new BailleurController(em, b);
	}

	@Test
	public void testSaveRecord(){
		
		Bailleur b1=new Bailleur();
		b1.setId("75");
		b1.setNom("TOGNON");
		bc.saveRecord(b1);
		Bailleur b2= (Bailleur)bc.findByProperty("id","75");
		assertNotNull(b2);
		assertEquals("75",b2.getId());
		Bailleur b3=new Bailleur();
		b3.setId("85");
		b3.setNom("KOUMAGNON");
		bc.saveRecord(b3);
		assertNotNull(b3);
		assertEquals("85",b3.getId());
		
	}
	

	@Test
	public void testUpdateRecord() {
		Bailleur b1= (Bailleur)bc.findByProperty("id","75");
		assertNotNull(b1);
		b1.setNom("HOUNTONDJI");
		bc.updateRecord(b1);
		assertEquals("HOUNTONDJI",b1.getNom());
		
	}

	@Test
	public void testDelete() {
//		fail("Not yet implemented");
	}

	@Test
	public void testFindByProperty() {
//		fail("Not yet implemented");
	}
	
	@Parameters
	public static Collection<Bailleur []> data(){
		
		return null;
	}

}
