package com.service;

import java.util.List;

import javax.jws.WebService;

import com.dao.UserDAO;
import com.model.User;

@WebService
public class UserService {

	public User getUserById(int id) {

		UserDAO userDao = new UserDAO();

		return userDao.getUserById(id);

	}

	public List<User> getAllUser() {

		UserDAO userDao = new UserDAO();

		return userDao.getAllUsers();
	}

	public List<User> getUserByIdInRange(int startId, int endId) {

		return null;

	}

	public boolean addUser(String firstName, String lastName, int userId) {

		UserDAO userDao = new UserDAO();
		return userDao.addUser(firstName, lastName, userId);

	}
	
	
	public User updateUser(String firstName , String lastName , int userId){
	
		UserDAO userDao = new UserDAO();
		return userDao.updateUser(firstName, lastName, userId);
		
		
	}
	
	
}
