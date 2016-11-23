package com.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle {

	@Id
	int id;
	String name;
	
	public Circle(){
		
	}
	
	public Circle(int radius , String name){
		
		this.id = radius;
		this.name = name;
	}
	
	public int getRadius() {
		return id;
	}
	public void setRadius(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
