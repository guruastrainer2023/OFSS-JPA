package com.training.ui;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.training.bean.pack1.Course;
import com.training.bean.pack1.Subject;
import com.training.util.JPAUtil;






public class Main1 {

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
	
	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		Course course = em.find(Course.class, 1);
		System.out.println(course);

		Subject subject = em.find(Subject.class, 6);
		System.out.println(subject);

		JPAUtil.closeEntityManager();
	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		String str = "from Course";
		Query query = em.createQuery(str);
		List allCourse = query.getResultList();
		System.out.println(allCourse);

		String str1 = "from Subject";
		Query query1 = em.createQuery(str1);
		List<Subject> allSubject = query1.getResultList();
		System.out.println(allSubject);

		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		Course course = em.find(Course.class, 1);

		Subject subjectToRemove = em.find(Subject.class, 1);

		course.removeSubject(subjectToRemove);

		Subject subject = em.find(Subject.class, 1);

		subject.setDurationInHours(12);

		em.merge(course);
		em.merge(subject);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void delete() {

		EntityManager em = JPAUtil.getEntityManager("PU");
		Course course = em.find(Course.class, 3);
		Subject subject = em.find(Subject.class, 1);

		em.getTransaction().begin();
		em.remove(course);
		em.remove(subject);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

		System.out.println("\t\t !>>>>>>>>>>> Deleted <<<<<<<<<<<<<<!");

	}

	public static void main(String[] args) {
		insertTesting();
		

	}

}
