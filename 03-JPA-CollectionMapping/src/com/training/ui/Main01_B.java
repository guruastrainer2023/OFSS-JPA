package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.training.bean.pack1.Candidate;
import com.training.bean.pack1.Question;

import com.training.util.JPAUtil;


public class Main01_B {
	
	
	static void insert(){
		
		/*
		 * String[] answers= {"Method Overriding", "Method Overloading"}; Question
		 * question=new Question("Runtime Polymorphism is implemented using", 1,
		 * answers);
		 */
		/*
		 * String[] answers= {"YES", "NO"}; Question question=new
		 * Question("Is Java Language Platform Independent", 1, answers);
		 */
		String[] answers= {"try", "catch", "finally", "throw", "throws"};
		Question question=new Question("Which of the following keywords are used for Exception Handling?", 2, answers);
		
		
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		
		em.persist(question);
		
		em.getTransaction().commit();
		
		System.out.println("Question Stored");
		JPAUtil.closeEntityManager();;
		
	}
	
	static void load() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		
		Question question;
		question=em.find(Question.class, 3);
		
		System.out.println(question);
		JPAUtil.closeEntityManager();
	}
	
	static void loadAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		
		TypedQuery<Question> questionQuery=em.createQuery("from Question",Question.class);
		List<Question> candidateList=questionQuery.getResultList();
		
		System.out.println(candidateList);
		JPAUtil.closeEntityManager();
	}
	
	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		
		
		Question question;
		question=em.find(Question.class, 3);
		
		question.setMark(5);
		
		em.getTransaction().begin();
		
		em.merge(question);
		
		em.getTransaction().commit();
		
		System.out.println("Question Updated");
	
		JPAUtil.closeEntityManager();
	}
	
	static void delete() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		
		
		Question question;
		question=em.find(Question.class, 3);
		
		
		
		
		em.getTransaction().begin();
		em.remove(question);
		
		em.getTransaction().commit();
		
		System.out.println("Question Removed");
	
		JPAUtil.closeEntityManager();
	}

	public static void main(String[] args) {
		insert();
		
		//load();
		
		//loadAll();
		
		//update();
		
		//delete();

	}

}
