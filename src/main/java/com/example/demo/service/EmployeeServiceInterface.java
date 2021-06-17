package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee employee);

	List<Employee> findAll();

	Employee findById(long id);

	void deleteEmployeeById(long id);

}
