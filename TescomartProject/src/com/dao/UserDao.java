package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();

		return true;
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

	public List<User> getAllUsers() {

		List<User> allUserList = new ArrayList<User>();

		String hql = "from User";
		Session session = UserDAO.getSessionFactory().openSession();

		TypedQuery<User> query = session.createQuery(hql);
		allUserList = query.getResultList();

		session.close();

		return allUserList;

	}

	public User updateUser(String firstName, String lastName, int userId) {

		User updatedUserObj = null;

		Session session = UserDAO.getSessionFactory().openSession();
		updatedUserObj = new User(firstName, lastName, userId);

		Transaction transaction = session.beginTransaction();

		session.update(updatedUserObj);

		transaction.commit();
		session.close();
		UserDAO.getSessionFactory().close();

		return updatedUserObj;

	}

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}

		return sessionFactory;
	}

}
