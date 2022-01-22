package com.spring.udemy.SpringRestFromUdemy.User;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

public class User {

	private Integer Id;
	
	@Size(min = 2 , message = "Lenght should be of size min 2")
	private String name;
	
	@Past(message = "the date should be less than the current date")
	private Date dob;

	public User(Integer id, String name, Date dob) {
		super();
		Id = id;
		this.name = name;
		this.dob = dob;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", dob=" + dob + "]";
	}

}
