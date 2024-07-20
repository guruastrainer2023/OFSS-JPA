package com.training.ui;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import com.training.bean.pack2.Course;
import com.training.bean.pack2.Subject;
import com.training.util.JPAUtil;







public class Main2 {

	private static void insertTesting() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		Course course=new Course("Induction Training", 32000.00);
		
		course.addSubject(new Subject("Spring", 42));
		course.addSubject(new Subject("JPA", 18));
		course.addSubject(new Subject("JQuery", 20));
		course.addSubject(new Subject("Angular JS", 50));
		course.addSubject(new Subject("Ajax", 5));
		
		
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		
		System.out.println("\t\t !>>>>>>>>>>> course Data Saved <<<<<<<<<<<<<<!");
	}

	private static void loadTesting() {
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		Course course=em.find(Course.class, 1);
		System.out.println(course);
		


	}

	private static void editTesting() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		Course course=em.find(Course.class, 1);
		System.out.println(course);
		
		course.setFee(course.getFee()+3000);
		course.setCourseName(course.getCourseName().toUpperCase());
		
		course.getSubjects().remove(em.find(Subject.class, 2));
		course.getSubjects().add(new Subject(" React JS",24));
		
		em.getTransaction().begin();
		em.merge(course);
		
		em.getTransaction().commit();
		
	}

	private static void deleteTesting() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		em.getTransaction().begin();
		Course course=em.find(Course.class, 1);
		em.remove(course);
		
		em.getTransaction().commit();
	

	}

	private static void loadAllTesting() {

		

	}

	public static void main(String[] args) {
		insertTesting();
		

	}

}
