package com.spring.udemy.SpringRestFromUdemy.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoUser {

	private static List<User> users = new ArrayList<>();
	private static int count = 3;
	static {
		users.add(new User(1, "Obul", new Date()));
		users.add(new User(2, "Sai", new Date()));
		users.add(new User(3, "Sriram", new Date()));
	}

	/*
	 * 1.Retrieve all users 
	 * 2.Create new user 
	 * 3.Retrieve one user
	 */
	public List<User> getAll() {
		return users;
	}

	public User createOne(User user) {
		if (user.getId() == 0) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}

	public User GetOneUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
