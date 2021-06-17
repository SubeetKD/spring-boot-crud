package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Currently using lombok is giving me error
 * after I downloaded the jar (chrisatmachina).
 */

@Entity
@Table(name = "employee_tbl")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	public Employee() {
		super();
	}
	public Employee(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
