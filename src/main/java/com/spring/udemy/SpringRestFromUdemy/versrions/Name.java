package com.spring.udemy.SpringRestFromUdemy.versrions;

public class Name {

	private String firstname;
	private String secondname;
	public Name(String firstname, String secondname) {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
	}
	public Name() {
		super();
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	
}
