package com.training.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.training.bean.pack3.ContactInfo;
import com.training.bean.pack3.Person;
import com.training.util.JPAUtil;





public class Main3 {
	static void test1() {
		Person person=new Person(101, "John", LocalDate.of(1998, 2, 20), 'M', null);
		
		ContactInfo contactInfo=new ContactInfo("John@gmail.com", "9764736738");
		person.setContactInfo(contactInfo);
		
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
	}
	
	static void test2() {
		Person person=new Person(102,"Jeya", LocalDate.of(2002, 2, 12), 'F', null);
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
	}
	
	static void test3() {
		ContactInfo contactInfo=new ContactInfo("Jeya2001@gmail.com", "8765819103");
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		Person person=em.find(Person.class, 102);
		person.setContactInfo(contactInfo);
		
		em.getTransaction().begin();
		em.persist(contactInfo);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
		
		
		
		
	}
	

	static void test4() {
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		ContactInfo contactInfo=em.find(ContactInfo.class, 2);
		System.out.println(contactInfo);
		
		JPAUtil.closeEntityManager();
	
		
	}
	
	static void test5() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		Person person=em.find(Person.class, 102);
		System.out.println(person);
		System.out.println(person.getContactInfo());
		
		JPAUtil.closeEntityManager();
		
	}
	
	
	static void test6() {
		
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		Person person=em.find(Person.class, 102);
		
		
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
		
		
	}
	
	


	public static void main(String[] args) {
		test1();

	}

}
