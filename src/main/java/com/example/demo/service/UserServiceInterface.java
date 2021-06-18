package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserServiceInterface {

	User addUser(User employee);

	List<User> findAll();

	User findById(long id);

	void deleteUserById(long id);

}
