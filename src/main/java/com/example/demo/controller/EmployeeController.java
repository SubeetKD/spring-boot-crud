package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceInterface;

import java.util.List;

import org.apache.catalina.connector.Response;
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

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface serviceInterface;
	
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    	Employee savedEmployee = serviceInterface.addEmployee(employee);
    	return new ResponseEntity<Employee>(savedEmployee,HttpStatus.CREATED);
    }
    
    @GetMapping("/findAllEmployee")
    public ResponseEntity<List<Employee>> findAll() {
    	List<Employee> listOfEmployee = serviceInterface.findAll();
    	return new ResponseEntity<List<Employee>>(listOfEmployee,HttpStatus.OK);
    }
    
    @GetMapping("/findEmployeeById/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") long id) {
    	Employee employee = serviceInterface.findById(id);
    	return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteEmployee/{id}")
    public  ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") long id) {
    	serviceInterface.deleteEmployeeById(id);
    	return new ResponseEntity<Void> (HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
    	serviceInterface.addEmployee(employee);
    	return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }
}
