package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.training.bean.pack2.Book;

import com.training.util.JPAUtil;


public class Main02_A {

	static void insert() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Book book = new Book("SCJP Certification Guide", "Kathy Sierra");
		book.addTopic("Java Fundamentals");
		book.addTopic("OOPS Concepts");
		book.addTopic("Polymorphism");
		book.addTopic("Collection API");

		em.getTransaction().begin();
		
		em.persist(book);
		
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		Book book;
		book = em.find(Book.class, 1);

		System.out.println(book);

		JPAUtil.closeEntityManager();
	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		TypedQuery<Book> bookQuery=em.createQuery("from Book",Book.class);
		List<Book> bookList=bookQuery.getResultList();
		
		System.out.println(bookList);
		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Book book;
		book = em.find(Book.class, 1);
		
		book.setBookName(book.getBookName().toUpperCase());
		book.getTopics().remove(book.getTopics().size()-1);

		System.out.println(book);
		em.getTransaction().begin();
		
		em.merge(book);
		
		em.getTransaction().commit();

		
		

		JPAUtil.closeEntityManager();
	}

	

	static void delete() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		Book book;
		book = em.find(Book.class, 1);
		
		book.setBookName(book.getBookName().toUpperCase());

		System.out.println(book);
		em.getTransaction().begin();
		
		em.remove(book);
		
		em.getTransaction().commit();

		
		

		JPAUtil.closeEntityManager();
	}

	public static void main(String[] args) {
		insert();
		//read();
		//update();
		
		//delete();

	}

}
