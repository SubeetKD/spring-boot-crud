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
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	/*
	 * This will consume external api for getting loaded.
	 * The setter will have to implement later.
	 */
	private String adharNumber;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(long id, String name, String adharNumber) {
		super();
		this.id = id;
		this.name = name;
		this.adharNumber = adharNumber;
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

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	
	public boolean hasAdhar() {
		if (this.adharNumber == null || this.adharNumber.isBlank() || this.adharNumber.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", adharNumber=" + adharNumber + "]";
	}

	
}
