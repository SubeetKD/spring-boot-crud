package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.custom.exception.ControllerException;
import com.example.demo.entity.User;
import com.example.demo.restClient.RestClient;
import com.example.demo.service.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceInterface serviceInterface;
	
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
    	
    	User anotherUser = new User(user.getName()+" 1");
    	anotherUser.setAdharNumber(RestClient.getAdhar());
    	
    	user.setAdharNumber(RestClient.getAdhar());
    	try {
    		User savedUser = serviceInterface.addUser(user);
        	return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
    	} catch (BusinessException e) {
    		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
    		return new ResponseEntity<ControllerException> (ce, HttpStatus.BAD_REQUEST);
    	}
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
    	try {
    		List<User> listOfUser = serviceInterface.findAll();
        	return new ResponseEntity<List<User>>(listOfUser,HttpStatus.OK);
    	} catch (BusinessException e) {
    		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
    		// TODO: check the error code for returning different HTTP response.
    		// for now only returning bad request
    		return new ResponseEntity<ControllerException> (ce, HttpStatus.BAD_REQUEST);
    	}
    
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") long id) {
    	try {
    		User user = serviceInterface.findById(id);
        	return new ResponseEntity<>(user,HttpStatus.OK);
    	} catch (BusinessException e) {
    		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
    		// TODO: check the error code for returning different HTTP response.
    		// for now only returning bad request
    		return new ResponseEntity<ControllerException> (ce, HttpStatus.BAD_REQUEST);
    	}
    }
    
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteUserById(@PathVariable("id") long id) {
    	try {
    		serviceInterface.deleteUserById(id);
        	return new ResponseEntity<Void> (HttpStatus.ACCEPTED);
    	} catch (BusinessException e) {
    		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
    		// TODO: check the error code for returning different HTTP response.
    		// for now only returning bad request
    		return new ResponseEntity<ControllerException> (ce, HttpStatus.BAD_REQUEST);
    	}
    }
    
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
    	try {
    		serviceInterface.addUser(user);
        	return new ResponseEntity<User>(user, HttpStatus.CREATED);
    	} catch (BusinessException e) {
    		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
    		// TODO: check the error code for returning different HTTP response.
    		// for now only returning bad request
    		return new ResponseEntity<ControllerException> (ce, HttpStatus.BAD_REQUEST);
    	}
    }
}
