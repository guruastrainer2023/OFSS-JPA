package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.training.bean.pack2.Category;
import com.training.bean.pack3.State;
import com.training.util.JPAUtil;


public class Main3 {

	static void insert() {
		State state1 = new State("Andhra");
		state1.addCityName("Hyderabad");
		state1.addCityName("Nellore");

		State state2 = new State("TamilNadu");
		state2.addCityName("Chennai");
		state2.addCityName("Coimbtaore");

		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		em.persist(state1);
		em.persist(state2);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		State state;

		state = em.find(State.class, 1);

		System.out.println(state);

		JPAUtil.closeEntityManager();
	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		String str = "from State";
		Query query = em.createQuery(str);
		List<State> allstate = query.getResultList();
		System.out.println(allstate);
		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		State state = em.find(State.class, 3);
		state.addCityName("pune");
		state.addCityName("delhi");

		state.setName(state.getName().toUpperCase());

		em.merge(state);
		em.getTransaction().commit();
		System.out.println(state);
		JPAUtil.closeEntityManager();
	}

	static void delete() {

		EntityManager em = JPAUtil.getEntityManager("PU");
		State state = em.find(State.class, 4);

		em.getTransaction().begin();
		em.remove(state);
		em.getTransaction().commit();
		System.out.println(state);
		JPAUtil.closeEntityManager();

	}

	public static void main(String[] args) {
		insert();
	}

}
