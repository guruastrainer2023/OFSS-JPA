package com.training.ui;

import java.util.List;

import com.training.bean.Address;
import com.training.bean.Employee;
import com.training.bean.Student;
import com.training.commons.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main4 {
	
	static void insertObjectToDB() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		
		/*
		 * Student student=new Student("Abinaya", 86); Address address=new
		 * Address("D-12", "5th Street", "Rose Garden", "Mumbai", "400050");
		 * student.setAddress(address);
		 */
		
		
		/*
		 * Student student=new Student("Chithra", 92); Address address=new
		 * Address("Plot 120 F-2", "2nd Main Road", "Velacherry", "Chennai", "600000");
		 * student.setAddress(address);
		 */
		
		Student student=new Student(101, "John", 88);
		Address address=new Address("FF-10", "RTO Office Road", "Habsiguda", "Hyderabad", "500001");
		student.setAddress(address);
		
		em.getTransaction().begin();
		
		em.persist(student);
		
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
	}
	
	static void loadObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Student student;
		student = em.find(Student.class, 3);
		System.out.println(student);

		JPAUtil.closeEntityManager();
	}

	static void loadAllObjectsFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Query query = em.createQuery("from Student", Student.class);
		List<Student> allStudents = query.getResultList();

		System.out.println(allStudents);

		JPAUtil.closeEntityManager();
	}

	static void deleteObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		
		Student student;
		student = em.find(Student.class, 3);
		System.out.println(student);
		
		
		
		em.remove(student);
		

		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void updateObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		
		Student student;
		student = em.find(Student.class, 3);
		System.out.println(student);
		
		student.setMarks(100);
		student.getAddress().setCity(student.getAddress().getCity().toUpperCase());
		
		em.merge(student);
		

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
