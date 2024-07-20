package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.training.bean.pack2.Category;
import com.training.util.JPAUtil;

public class Main02_B {

	static void insert() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Category category1=new Category("Web");
		category1.add("html");
		category1.add("css");
		category1.add("js");
		
		Category category2=new Category("RDBMS");
		category2.add("Oracle 12c");
		category2.add("MySQL8");

		em.getTransaction().begin();
		
		em.persist(category1);
		em.persist(category2);
		
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		Category category;
		category = em.find(Category.class, 1);

		System.out.println(category);

		JPAUtil.closeEntityManager();
	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		TypedQuery<Category> categoryQuery=em.createQuery("from Category",Category.class);
		List<Category> categoryList=categoryQuery.getResultList();
		
		System.out.println(categoryList);
		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		Category category;
		category = em.find(Category.class, 1);

	    category.add("Angular");
	    category.add("React JS");
	    category.remove("html");

		System.out.println(category);
		
		em.getTransaction().begin();
		
		em.merge(category);
		
		em.getTransaction().commit();

		
		

		JPAUtil.closeEntityManager();
	}

	

	static void delete() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		Category category;
		category = em.find(Category.class, 1);
		
		
		System.out.println(category);
		em.getTransaction().begin();
		
		em.remove(category);
		
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
