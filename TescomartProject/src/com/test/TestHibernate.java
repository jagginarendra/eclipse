package com.test;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.User;

public class TestHibernate {

	public static void main(String[] args) {

		TestHibernate obj = new TestHibernate();
		User user = obj.getUserById(5);
		System.out.println(user.getFirstName() + " " + user.getLastName());
	}

	public User getUserById(int userID) {

		User user = null;

		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		IdentifierLoadAccess identifier = session.byId(User.class);

		user = (User) identifier.getReference(new Integer(userID));

		// user = (User) session.get(User.class , userID);
		session.close();

		return user;
	}

	public void insertRecord() {
		User obj = new User();
		obj.setFirstName("Rahul");
		obj.setLastName("Dravid");
		obj.setUserId(7);

		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {

			// StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();
	}
}
