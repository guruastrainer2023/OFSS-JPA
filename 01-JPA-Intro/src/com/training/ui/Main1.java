package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.training.bean.Person;
import com.training.commons.UIInputModule;

public class Main1 {

	static void insertObject() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Person person = new Person("Ram", "Sharma", 26);
		em.persist(person);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	static void loadObject() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

		EntityManager em = emf.createEntityManager();

		Person person = em.find(Person.class, 1352);

		System.out.println(person);

		em.close();
		emf.close();

	}
	
	static void loadAllObjects() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

		EntityManager em = emf.createEntityManager();
		
		Query query=em.createQuery("select p from Person p");
		
		List<Person> allPersons=query.getResultList();
		System.out.println(allPersons);
		em.close();
		emf.close();

	}
	
	static void updateObject() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person=em.find(Person.class, 1352);
		person.setAge(person.getAge()+2);
		em.merge(person);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
	
	static void deleteObject() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person=em.find(Person.class, 1354);
		
		em.remove(person);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void main(String[] args) {

		//insertObject();
		// loadObject();
		//loadAllObjects();
		
		//updateObject();
		
		deleteObject();
		//insertObject();
		

	}

}
