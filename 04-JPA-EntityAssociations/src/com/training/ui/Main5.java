package com.training.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.training.bean.pack5.ContactInfo;
import com.training.bean.pack5.Person;
import com.training.util.JPAUtil;




public class Main5 {
	static void test1() {
		Person person=new Person("John", LocalDate.of(1998, 2, 20), 'M');
		
		ContactInfo contactInfo=new ContactInfo("John@gmail.com", "9764736738");
		person.setContactInfo(contactInfo);
	
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
	}
	
	static void test2() {
		ContactInfo contactInfo=new ContactInfo("Jeya2001@gmail.com", "8765819103");
		Person person=new Person("Ram", LocalDate.of(1998, 10, 12), 'M');
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		//Person person=em.find(Person.class, 102);
		
		em.getTransaction().begin();
		em.persist(contactInfo);
		em.persist(person);
		em.getTransaction().commit();
		JPAUtil.closeEntityManager();
		
	}
	
	static void test3() {
	
		
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		Person person=em.find(Person.class, 1);
		ContactInfo contactInfo=em.find(ContactInfo.class, 1);
	
		person.setContactInfo(contactInfo);
		
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
		JPAUtil.closeEntityManager();
	}
	
	

	static void test4() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		
		ContactInfo contactInfo=em.find(ContactInfo.class, 1);
		
	
		
		System.out.println(contactInfo);
		JPAUtil.closeEntityManager();
		
	}
	
	static void test5() {
		
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		Person person=em.find(Person.class, 1);
			
		System.out.println(person);
		JPAUtil.closeEntityManager();
		
		
		
	}
	
	
	static void test6() {
		
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		ContactInfo contactInfo=em.find(ContactInfo.class, 2);
		
		
		em.getTransaction().begin();
		em.remove(contactInfo);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
		
	}
	

	public static void main(String[] args) {
		test1();

	}

}
