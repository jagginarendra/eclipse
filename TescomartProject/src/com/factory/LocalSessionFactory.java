package com.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class LocalSessionFactory {

	public static org.hibernate.SessionFactory getSession() {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = null;
		try {

			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception e) {

			System.out.println("Exception in Session Factory Creation");

		}

		return sessionFactory;
	}

}
