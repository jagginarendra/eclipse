package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.User;

public class TestHibernate {

	public static void main(String[] args) {
		
		User obj = new User();
		obj.setFirstName("Rahul");
		obj.setLastName("Dravid");
		obj.setUserId(7);

		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {

			//StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();
		
	}
}
