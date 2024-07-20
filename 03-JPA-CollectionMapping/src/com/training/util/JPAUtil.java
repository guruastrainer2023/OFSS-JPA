package com.training.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static EntityManager getEntityManager(String puName) {
		if(emf==null)
			emf=Persistence.createEntityManagerFactory(puName);
		if(em==null)
			em=emf.createEntityManager();
		return em;
	}
	
	public static void closeEntityManager() {
		if(em!=null)
			em.close();
		if(emf!=null)
			 emf.close();
	}

}
