package com.service;

import java.util.List;

import javax.jws.WebService;

import com.dao.UserDAO;
import com.model.User;

@WebService
public class UserService {

	public User getUserById(int id) {

		return null;

	}

	public List<User> getAllUser() {

		return null;
	}

	public List<User> getUserByIdInRange(int startId, int endId) {

		return null;

	}

	public boolean addUser(String firstName, String lastName, int userId) {

		UserDAO userDao = new UserDAO();
		return userDao.addUser(firstName, lastName, userId);

	}
}
