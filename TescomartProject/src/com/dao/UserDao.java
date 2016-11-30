package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.User;

public class UserDAO {

	public boolean addUser(String firstName, String lastName, int id) {

		User obj = new User();
		obj.setFirstName(firstName);
		obj.setLastName(lastName);
		obj.setUserId(id);

		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {

			StandardServiceRegistryBuilder.destroy(registry);
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();

		return true;
	}

}
