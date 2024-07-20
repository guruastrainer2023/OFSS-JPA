package com.training.ui;

import java.time.LocalDate;
import java.util.List;

import com.training.bean.Employee;
import com.training.bean.Gender;
import com.training.commons.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main2 {

	static void insertObjectToDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();

		Employee employee;
		/*
		 * employee=new Employee("Priya", 15000.00, 'A',LocalDate.of(1998,4,10),
		 * LocalDate.of(2018,6,12), false, Gender.FEMALE);
		 */
		/*
		 * employee=new Employee("Gaurav", 14000.00, 'B',LocalDate.of(1997,3,20),
		 * LocalDate.of(2019,8,5), false, Gender.MALE);
		 */

		/*
		 * employee=new Employee("Abhishek Singh", 11000.00,
		 * 'C',LocalDate.of(1999,2,10), LocalDate.of(2022,8,14), false, Gender.MALE);
		 */

		employee = new Employee( "Mohit", 25000.00, 'A', LocalDate.of(1996, 10, 8), LocalDate.of(2015, 10, 12), 1,
				Gender.MALE);

		em.persist(employee);

		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void loadObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Employee employee;
		employee = em.find(Employee.class, 5);
		System.out.println(employee);

		JPAUtil.closeEntityManager();
	}

	static void loadAllObjectsFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Query query = em.createQuery("select e from Employee e", Employee.class);
		List<Employee> allEmployees = query.getResultList();

		System.out.println(allEmployees);

		JPAUtil.closeEntityManager();
	}

	static void deleteObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		
		Employee employee;
		employee = em.find(Employee.class, 5);
		System.out.println(employee);
		em.remove(employee);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void updateObjectFromDB() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		
		Employee employee;
		employee = em.find(Employee.class, 5);
		System.out.println(employee);
		
		employee.setBasicSalary(employee.getBasicSalary()+ employee.getBasicSalary()*0.1);
		
		em.merge(employee);
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
