package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.model.User;

@WebService
public class UserService {

	public List<User> getAllUsers() {

		User obj = new User();
		obj.setUserId("1000");
		obj.setFirstName("Hitesh");
		obj.setLastName("Jain");
		
		User obj1 = new User();
		obj1.setUserId("1001");
		obj1.setFirstName("Akash");
		obj1.setLastName("Jain");

		List<User> list = new ArrayList<User>();
		list.add(obj);
		list.add(obj1);

		return list;
	}
}
