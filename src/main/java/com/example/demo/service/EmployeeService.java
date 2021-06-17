package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

/*
 * This method returns the required value not response entity
 * that should be handled by the the controller class.
 */

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository repo;

	@Override
    public Employee addEmployee(Employee employee) {
		System.out.println("Employee added " + employee.toString());
        return repo.save(employee);
    }
	
	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}

	@Override
	public Employee findById(long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployeeById(long id) {
		repo.deleteById(id);
	}

}
