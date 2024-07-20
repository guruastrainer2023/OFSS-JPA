package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.training.bean.pack1.Candidate;

import com.training.util.JPAUtil;


public class Main01_A {

	static void insert() {
		/*
		 * double[] scores={8.6, 9.1, 10.0}; Candidate candidate=new Candidate();
		 * candidate.setName("Sheela"); candidate.setCity("Bangalore");
		 * candidate.setMarks(scores);
		 */

		/*
		 * double[] scores={5.1, 9.0, 6.7}; Candidate candidate=new Candidate();
		 * candidate.setName("Priya"); candidate.setCity("Hyderabad");
		 * candidate.setMarks(scores);
		 */

		Double[] scores = { 7.8, 5.0, 6.1 };
		
		Candidate candidate = new Candidate();
		candidate.setName("Sneha");
		candidate.setCity("Chennai");
		
		candidate.setMarks(scores);

		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();

		em.persist(candidate);

		em.getTransaction().commit();

		System.out.println("Candidate Stored");
		JPAUtil.closeEntityManager();

	}

	static void load() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Candidate candidate;
		candidate = em.find(Candidate.class, 1);

		System.out.println(candidate);
		JPAUtil.closeEntityManager();
	}

	static void loadAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();

		TypedQuery<Candidate> candidateQuery = em.createQuery("from Candidate", Candidate.class);
		List<Candidate> candidateList = candidateQuery.getResultList();

		System.out.println(candidateList);

	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Candidate candidate;
		candidate = em.find(Candidate.class, 1);
		candidate.setName(candidate.getName().toUpperCase());
		candidate.setMarks(new Double[] { 3.0, 4.0, 5.0, 6.0, 7.0 });

		em.getTransaction().begin();

		em.merge(candidate);

		em.getTransaction().commit();

		System.out.println("Candidate Updated");

		JPAUtil.closeEntityManager();
	}

	static void delete() {

		EntityManager em = JPAUtil.getEntityManager("PU");

		Candidate candidate;
		candidate = em.find(Candidate.class, 3);

		em.getTransaction().begin();

		em.remove(candidate);

		em.getTransaction().commit();
		

		System.out.println("Candidate Deleted");
		JPAUtil.closeEntityManager();

	}

	public static void main(String[] args) {
		insert();

		// load();

		// loadAll();

		// update();

		// delete();

	}

}
