package com.test.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

	
	private LocalSessionFactoryBean localSessionFactory;
	
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public LocalSessionFactoryBean getLocalSessionFactory() {
		return localSessionFactory;
	}

	@Autowired
	public void setLocalSessionFactory(LocalSessionFactoryBean localSessionFactory) {
		this.localSessionFactory = localSessionFactory;
		this.sessionFactory = localSessionFactory.getObject();
		System.out.println("hellooo");
	}

	



	public long getCircleCount() {

		long count = 0;
		String hql = "select count(*) from Circle";
		Query query = getSessionFactory().openSession().createQuery(hql);
		count = (long) query.getSingleResult();

		return count;
	}

}
