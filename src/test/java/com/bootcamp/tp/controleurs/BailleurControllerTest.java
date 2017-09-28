package com.bootcamp.tp.controleurs;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;

public class BailleurControllerTest {

	private EntityManagerFactory emf=null;
	
	public BailleurControllerTest(EntityManagerFactory emf){
		
		this.emf=emf;
	}
	

	@Test
	public void testFindBailleurByName() {
		BailleurController bc=new BailleurController(emf);
		Integer realbId=Integer.parseInt(bc.findBailleurByName("TO").get(0).getId());
		Integer expectedbId=3;
		assertEquals(expectedbId, realbId);
//		fail("Not yet implemented");
	}

	@Test
	public void testFindBailleurEntities() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBailleurEntitiesIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBailleur() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBailleurCount() {
		fail("Not yet implemented");
	}

}
