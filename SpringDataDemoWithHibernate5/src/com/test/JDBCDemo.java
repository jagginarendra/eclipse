package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.HibernateDaoImpl;
import com.test.dao.JDBCDemoImpl;
import com.test.model.Circle;



public class JDBCDemo {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl demoObj = context.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		
		
		//Circle circle = new JDBCDemoImpl().getCircle(1);
		//System.out.println(deomObj.getCircle(1).getName());
		
		//System.out.println(demoObj.getCircleForId(2).getName());
		
		//demoObj.getAllCircle();
		
		Circle circle  = new Circle(4, "Fourth Circle");
		
		//demoObj.insertCircle(circle);
		
		//demoObj.insertCircleNamedParam(circle);
	
		System.out.println(demoObj.getCircleCount());
	}

}
