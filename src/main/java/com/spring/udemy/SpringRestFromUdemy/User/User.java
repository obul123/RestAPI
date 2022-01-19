package com.spring.udemy.SpringRestFromUdemy.User;

import java.util.Date;

public class User {

	private Integer Id;
	private String name;
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
