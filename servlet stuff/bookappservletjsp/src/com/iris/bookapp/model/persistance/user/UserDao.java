package com.iris.bookapp.model.persistance.user;

import java.util.List;

public interface UserDao {
	public List<User> getAll();
	public User add(User user);
	public User delete(String username);
	public User update(User user);
	public User getUser(String username, String password);
}
