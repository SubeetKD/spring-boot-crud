package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/*
 * This method returns the required value not response entity
 * that should be handled by the the controller class.
 */

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository repo;

	@Override
    public User addUser(User user) throws BusinessException {

		try {
			if (user.getName().isEmpty() && user.getName().isBlank()) {
				throw new BusinessException("601","Please send proper name. It's blank");
			}
			User savedUser = repo.save(user);
			return savedUser;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Wrong arguments. " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in Service layer while saving employee. " + e.getMessage());
		}
    }
	
	@Override
	public List<User> findAll() {
		try {
			List<User> listUser = repo.findAll();
			if (listUser.isEmpty()) {
				throw new BusinessException("604", "Employee List is empty, nothing to return.");
			}
			return listUser;
		} catch (Exception e) {
			throw new BusinessException("605", "Something went wrong in Service layer while fetching all employees. " + e.getMessage());
		}
	}

	@Override
	public User findById(long id) {
		try {
			User user = repo.findById(id).get();
			return user;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "Given id is null. Enter valid id. " + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("607", "Employee with the given id does not exist in database. " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("608", "Something went wrong in the service layer while fetching the Employee with id " + id + ". " + e.getMessage());
		}
		
	}

	@Override
	public void deleteUserById(long id) {
		try {
			repo.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "Invalid Id. " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("609", "Something went wrong in the service layer while deleteing Employee by id. " + e.getMessage());
		}
		
	}
	

}
