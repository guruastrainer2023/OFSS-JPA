package com.training.ui;

import java.time.LocalDate;
import java.util.List;

import com.training.bean.Contact;
import com.training.bean.Employee;
import com.training.commons.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class Main3 {
	
	
	
	
	static void insertObjectToDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();

		Contact contact;
		//contact=new Contact("Kruba", "Shankar");
		//contact=new Contact("Ram", "Yadhav");
		contact=new Contact("Jayam", "Ravi");
		
		em.persist(contact);

		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void loadObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		Contact contact=em.find(Contact.class, 3);
		System.out.println(contact);

		JPAUtil.closeEntityManager();
	}

	static void loadAllObjectsFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		Query query = em.createQuery("from Contact", Contact.class);
		List<Contact> allContacts = query.getResultList();

		System.out.println(allContacts);


		JPAUtil.closeEntityManager();
	}

	static void deleteObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		
		Contact contact=em.find(Contact.class, 3);
		System.out.println(contact);
		
		
		
		em.remove(contact);
		

		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void updateObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		
		Contact contact=em.find(Contact.class, 3);
		System.out.println(contact);
		contact.setFirstName(contact.getFirstName().toUpperCase());
		contact.setLastName(contact.getLastName().toUpperCase());
		
		
		em.merge(contact);
		

		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

		
	
	
	

	public static void main(String[] args) {
		//insertObjectToDB();
		
		//loadObjectFromDB();
		
		//loadAllObjectsFromDB();
		
		//updateObjectFromDB();
		
		deleteObjectFromDB();

	}

}
