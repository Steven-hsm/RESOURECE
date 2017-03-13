package com.hsm.dao;

import java.util.List;

import com.hsm.model.User;

public interface UserDao {
	/* @Select("select * from user where id= #{id}")*/
	public User getUserByID(int id);
	
	public List<User> getUserList();

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int userId);
	
	public User getUser(int id);
}
